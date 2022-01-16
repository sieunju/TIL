package com.hmju.presentation.simple_like_recyclerview

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/15
 */
object SimpleLikeRecyclerViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("isLikeId")
    fun setIsLikeGoods(
        view: View,
        id: Long?
    ) {
        if (id == null) return

        view.isSelected = com.hmju.likemanager.LikeManager.isLike(id)
    }

    @JvmStatic
    @BindingAdapter("htmlText")
    fun setHtmlTextView(
        tv: AppCompatTextView,
        text: String?
    ) {
        if (text.isNullOrEmpty()) return

        tv.text = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    @JvmStatic
    @BindingAdapter("imgPath")
    fun setLoadImageUrl(
        img: AppCompatImageView,
        url: String?
    ) {
        if (url.isNullOrEmpty()) {
            img.visibility = View.INVISIBLE
            return
        }

        Glide.with(img.context)
            .load(url)
            .into(img)
    }
}