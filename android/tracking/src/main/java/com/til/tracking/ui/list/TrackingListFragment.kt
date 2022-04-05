package com.til.tracking.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.til.tracking.Extensions
import com.til.tracking.R
import com.til.tracking.TrackingManager
import com.til.tracking.databinding.FTrackingListBinding
import com.til.tracking.models.BaseTrackingUiModel
import com.til.tracking.models.TrackingListUiModel
import com.til.tracking.rx.TrackingNotifyChangeEvent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo

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

    private lateinit var adapter: Extensions.TrackingAdapter

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
        adapter = Extensions.TrackingAdapter()
        binding.rvContents.adapter = adapter
        updateData()

        TrackingNotifyChangeEvent.listen()
            .take(TrackingManager.getInstance().getUpdateTake())
            .subscribe({
                updateData()
            }, {

            }).addTo(disposable)
    }

    /**
     * 데이터 업데이트 처리 함수
     */
    private fun updateData() {
        val uiList = mutableListOf<BaseTrackingUiModel>()
        TrackingManager.getInstance().getTrackingList().forEach {
            uiList.add(TrackingListUiModel(it))
        }
        adapter.submitList(uiList)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}