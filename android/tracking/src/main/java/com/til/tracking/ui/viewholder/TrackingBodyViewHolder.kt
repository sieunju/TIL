package com.til.tracking.ui.viewholder

import android.view.ViewGroup
import com.til.tracking.BR
import com.til.tracking.R
import com.til.tracking.databinding.VhTrackingBodyBinding

internal class TrackingBodyViewHolder(parent: ViewGroup) : BaseTrackingViewHolder<VhTrackingBodyBinding>(
    parent,
    R.layout.vh_tracking_body
) {
    init {
        itemView.setOnLongClickListener {
            binding.model?.runCatching {
                simpleLongClickCopy(body)
            }
            return@setOnLongClickListener false
        }
    }
    override fun onBindView(model: Any) {
        binding.setVariable(BR.model, model)
    }
}
