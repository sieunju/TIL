package com.hmju.presentation.simple_like_recyclerview

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hmju.domain.usecase.GetGoodsUseCase
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseSimpleLikeViewHolder
import com.hmju.presentation.databinding.FSimpleLikeRecyclerviewBinding
import com.til.model.goods.GoodsEntity
import com.til.model.params.GoodsParamMap
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Description : 뷰모델과 뷰홀더간의 의존성을 떼어내기 위한 학습? 공부? 고민?
 * Fragment
 *
 * Created by juhongmin on 2022/01/15
 */
@AndroidEntryPoint
class SimpleLikeRecyclerViewFragment : Fragment(R.layout.f_simple_like_recyclerview) {

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    @Inject
    lateinit var getGoodsListUseCase: GetGoodsUseCase

    private val oneTypeQuery = GoodsParamMap()
    private val twoTypeQuery = GoodsParamMap()

    private val oneAdapter = Adapter(true)
    private val twoAdapter = Adapter(false)
    private val oneList: MutableList<GoodsEntity> by lazy { mutableListOf() }
    private val twoList: MutableList<GoodsEntity> by lazy { mutableListOf() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FSimpleLikeRecyclerviewBinding>(view)?.run {
            rvTop.adapter = oneAdapter
            rvBottom.adapter = twoAdapter

            button.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction().apply {
                    add(R.id.fragment, SimpleLikeRecyclerViewFragment())
                    addToBackStack(null)
                    commit()
                }
            }
        }

        getGoodsListUseCase(oneTypeQuery)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                oneList.addAll(it)
                oneAdapter.submitList(oneList)
            }, {

            })

        getGoodsListUseCase(twoTypeQuery)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                twoList.addAll(it)
                twoAdapter.submitList(twoList)
            }, {

            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

    class Adapter(private val isOneType: Boolean) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        companion object {
            class SimpleLikeDiffUtil(
                private val oldList: List<GoodsEntity>,
                private val newList: List<GoodsEntity>
            ) : DiffUtil.Callback() {
                override fun getOldListSize(): Int {
                    return oldList.size
                }

                override fun getNewListSize(): Int {
                    return newList.size
                }

                override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean {
                    return oldList[oldPos].id == newList[newPos].id
                }

                override fun areContentsTheSame(
                    oldPos: Int,
                    newPos: Int
                ): Boolean {
                    return oldList[oldPos] == newList[newPos]
                }
            }
        }

        private val dataList: MutableList<GoodsEntity> by lazy { mutableListOf() }

        fun submitList(newList: List<GoodsEntity>?) {
            if (newList == null) return

            val diffResult = DiffUtil.calculateDiff(SimpleLikeDiffUtil(dataList, newList))
            dataList.clear()
            dataList.addAll(newList)
            diffResult.dispatchUpdatesTo(this)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return if (isOneType) {
                SimpleLike1ViewHolder(parent)
            } else {
                SimpleLike2ViewHolder(parent)
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if (holder is BaseSimpleLikeViewHolder<*>) {
                holder.onBindView(dataList[position])
            }
        }

        override fun getItemCount(): Int {
            return dataList.size
        }
    }
}