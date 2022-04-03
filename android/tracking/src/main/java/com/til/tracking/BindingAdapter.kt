package com.til.tracking

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/03
 */
internal object BindingAdapter {

    @JvmStatic
    @BindingAdapter("android:text")
    fun setText(
        tv: AppCompatTextView,
        newTxt: String?
    ) {
        if (!newTxt.isNullOrEmpty()) {
            val oldTxt = tv.text
            if (newTxt == oldTxt) return

            tv.text = newTxt
        } else {
            tv.visibility = View.GONE
        }
    }
}