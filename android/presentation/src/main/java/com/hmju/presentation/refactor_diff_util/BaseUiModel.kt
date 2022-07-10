package com.hmju.presentation.refactor_diff_util

import androidx.annotation.LayoutRes

abstract class BaseUiModel(@LayoutRes val layoutId: Int) {

    abstract fun getClassName(): String

    abstract fun areItemsTheSame(diffItem: Any): Boolean

    abstract fun areContentsTheSame(diffItem: Any): Boolean
}
