package com.hmju.presentation.custompaging

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Description : DataBinding 방식의 페이징 처리 BindingAdapter
 *
 * Created by juhongmin on 2022/01/21
 */
object CustomPagingBindingAdapter {

    interface PagingListener {
        fun loadPage()
    }

    @JvmStatic
    @BindingAdapter(value = ["pagingModel", "onLoadNextPage"], requireAll = false)
    fun setPagingListener(
        rv: RecyclerView,
        model: PagingModel,
        callback: PagingListener?
    ) {
        if (callback == null) return

        rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (model.isLast || model.isLoading || recyclerView.adapter == null) {
                    return
                } else {
                    val itemCount = recyclerView.adapter?.itemCount ?: 0
                    var pos = 0
                    when (val lm = recyclerView.layoutManager) {
                        is LinearLayoutManager -> pos = lm.findLastVisibleItemPosition()
                    }
                    val updatePosition = itemCount - pos / 2
                    if (pos >= updatePosition) {
                        callback.loadPage()
                    }
                }
            }
        })
    }
}
