package com.til.tracking.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.til.tracking.BR
import com.til.tracking.R
import com.til.tracking.TrackingManager
import com.til.tracking.databinding.FTrackingListBinding
import com.til.tracking.databinding.VhChildTrackingBinding
import com.til.tracking.entity.TrackingHttpEntity
import com.til.tracking.rx.TrackingDetailEvent
import com.til.tracking.rx.TrackingNotifyChangeEvent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import timber.log.Timber

/**
 * Description : HTTP 트레킹 Fragment
 *
 * Created by juhongmin on 2022/04/01
 */
internal class TrackingListFragment : Fragment() {

    companion object {
        fun newInstance(): TrackingListFragment = TrackingListFragment()
    }

    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }

    private lateinit var binding: FTrackingListBinding

    private val adapter: Adapter by lazy { Adapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DataBindingUtil.inflate<FTrackingListBinding>(
            inflater,
            R.layout.f_tracking_list,
            container,
            false
        ).run {
            binding = this
            return@run root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvContents.adapter = adapter
        adapter.submitList(TrackingManager.getInstance().getTrackingList())

        TrackingNotifyChangeEvent.listen()
            .take(TrackingManager.getInstance().getUpdateTake())
            .subscribe({
                adapter.submitList(TrackingManager.getInstance().getTrackingList())
            }, {

            }).addTo(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

    class Adapter : RecyclerView.Adapter<ViewHolder>() {

        companion object {
            class TrackingDiffUtil(
                private val oldList: List<TrackingHttpEntity>,
                private val newList: List<TrackingHttpEntity>
            ) : DiffUtil.Callback() {
                override fun getOldListSize(): Int {
                    return oldList.size
                }

                override fun getNewListSize(): Int {
                    return newList.size
                }

                override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean {
                    return oldList[oldPos].uid == newList[newPos].uid
                }

                override fun areContentsTheSame(
                    oldPos: Int,
                    newPos: Int
                ): Boolean {
                    return oldList[oldPos] == newList[newPos]
                }
            }
        }

        private val dataList: MutableList<TrackingHttpEntity> by lazy { mutableListOf() }

        fun submitList(newList: List<TrackingHttpEntity>?) {
            if (newList == null) return
            Timber.d("NewList ${newList.size}")
            val diffResult = DiffUtil.calculateDiff(TrackingDiffUtil(dataList, newList))
            dataList.clear()
            dataList.addAll(newList)
            diffResult.dispatchUpdatesTo(this)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(parent)
        }

        override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
            if (pos < dataList.size) {
                holder.onBindView(dataList[pos])
            }
        }

        override fun getItemCount(): Int {
            return dataList.size
        }
    }

    class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.vh_child_tracking, parent, false)
    ) {
        val binding: VhChildTrackingBinding by lazy { VhChildTrackingBinding.bind(itemView) }

        init {
            itemView.setOnClickListener {
                binding.item?.runCatching {
                    TrackingDetailEvent.publish(this)
                }
            }
        }

        fun onBindView(item: TrackingHttpEntity) {
            binding.setVariable(BR.item, item)
        }
    }
}