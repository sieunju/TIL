package com.hmju.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.view.doOnAttach
import androidx.core.view.doOnDetach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.recyclerview.widget.RecyclerView

/**
 * Description : TIL 공통 ViewHolder Class
 *
 * Created by juhongmin on 2022/02/16
 */
abstract class BaseViewHolder<T : ViewDataBinding>(
    parent: ViewGroup,
    @LayoutRes layoutId: Int
) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false)) {

    val binding: T by lazy { DataBindingUtil.bind(itemView)!! }

    abstract fun onBindView(item: Any)

    open fun onViewAttachedToWindow() {

    }

    open fun onViewDetachedFromWindow() {

    }

    /**
     * set Lifecycle 필요시에만 함수 호출 할것
     */
    protected fun setLifecycleOwner() {
        itemView.doOnAttach {
            try {
                binding.lifecycleOwner = ViewTreeLifecycleOwner.get(it)
            } catch (ex: Exception) {
                // data binding failed to call observer method 변경된 BindingAdapter 나 xml 에서 databinding
            }
        }
        itemView.doOnDetach {
            binding.lifecycleOwner = null
        }
    }
}
