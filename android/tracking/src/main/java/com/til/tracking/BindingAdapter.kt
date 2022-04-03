package com.til.tracking

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.HtmlCompat
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
            val htmlText = HtmlCompat.fromHtml(newTxt, HtmlCompat.FROM_HTML_MODE_LEGACY)
            tv.text = htmlText
        } else {
            tv.visibility = View.GONE
        }
    }
}