package com.hmju.presentation

import android.content.ContextWrapper
import android.view.View
import androidx.fragment.app.FragmentActivity

/**
 * FragmentActivity 가져오는 View 기반 확장 함수
 * @return FragmentActivity Nullable
 */
fun View.getFragmentActivity(): FragmentActivity? {
    if (context is FragmentActivity) {
        return context as FragmentActivity
    } else if (context is ContextWrapper) {
        var tmpContext = this.context
        while (tmpContext is ContextWrapper) {
            if (tmpContext is FragmentActivity) {
                return tmpContext
            }
            tmpContext = tmpContext.baseContext
        }
    }
    return null
}
