package com.til.tracking.ui.viewholder

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.til.tracking.R
import timber.log.Timber

internal abstract class BaseTrackingViewHolder<T : ViewDataBinding>(
    parent: ViewGroup,
    @LayoutRes layoutId: Int
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
) {
    private val clipboard =
        itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val binding: T by lazy { DataBindingUtil.bind(itemView)!! }

    @Throws(Exception::class)
    abstract fun onBindView(model: Any)

    /**
     * 길게 눌렀을때 해당 내용 복사 되도록 처리
     */
    protected fun simpleLongClickCopy(txt: String) {
        val clip: ClipData = ClipData.newPlainText("HttpLogging", txt)
        clipboard.setPrimaryClip(clip)
        Snackbar.make(itemView, R.string.txt_copy_success, Snackbar.LENGTH_SHORT)
            .apply {
                setTextColor(ContextCompat.getColor(itemView.context,R.color.black))
                setBackgroundTint(ContextCompat.getColor(itemView.context,R.color.white))
            }
            .show()
    }
}
