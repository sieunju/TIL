package com.hmju.presentation.refactor_diff_util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hmju.presentation.base.ItemListAdapter

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/16
 */
object RefactorDiffUtilBindingAdapter {

    interface DiffIdTheSameListener {
        fun callback(oldItem: Any, newItem: Any): Boolean
    }

    interface DiffContentsTheSameListener {
        fun callback(oldItem: Any, newItem: Any): Boolean
    }

    @JvmStatic
    @BindingAdapter(value = ["dataList", "itemTheSame", "contentsTheSame"], requireAll = false)
    fun setDataListAndAdapter(
        rv: RecyclerView,
        dataList: List<BaseUiModel>?,
        itemTheSame: DiffIdTheSameListener?,
        contentsTheSame: DiffContentsTheSameListener?
    ) {
        if (rv.adapter == null) {
            rv.adapter = ItemListAdapter()
        }

        (rv.adapter as ItemListAdapter).run {
            if (itemTheSame != null && contentsTheSame != null) {
                submitList(dataList, itemTheSame, contentsTheSame)
            }
        }
    }
}