package com.hmju.presentation.custompaging

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hmju.presentation.BR
import com.hmju.presentation.R
import com.hmju.presentation.databinding.FCustomPagingBinding
import com.hmju.presentation.simple_like_recyclerview.BaseSimpleLikeViewHolder
import com.hmju.presentation.simple_like_recyclerview.SimpleLike1ViewHolder
import com.hmju.presentation.simple_like_recyclerview.SimpleLikeRecyclerViewFragment
import com.til.model.goods.GoodsEntity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/21
 */
@AndroidEntryPoint
class CustomPagingFragment : Fragment(R.layout.f_custom_paging){

    private val viewModel : CustomPagingViewModel by viewModels()

    private val adapter = Adapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FCustomPagingBinding>(view)?.run {
            lifecycleOwner = this@CustomPagingFragment
            setVariable(BR.vm,viewModel)
            rvContents.adapter = adapter
        }
        with(viewModel) {
            dataList.observe(viewLifecycleOwner,{ list->
                adapter.submitList(list)
            })
            start()
        }
    }

    class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

        companion object {
            class CustomPagingDiffUtil(
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

            val diffResult = DiffUtil.calculateDiff(
                SimpleLikeRecyclerViewFragment.Adapter.Companion.SimpleLikeDiffUtil(
                    dataList,
                    newList
                )
            )
            dataList.clear()
            dataList.addAll(newList)
            diffResult.dispatchUpdatesTo(this)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return SimpleLike1ViewHolder(parent)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if(holder is BaseSimpleLikeViewHolder<*>) {
                holder.onBindView(dataList[position])
            }
        }

        override fun getItemCount(): Int {
            return dataList.size
        }
    }
}