package com.til.tracking.ui.viewholder

import android.view.ViewGroup
import com.til.tracking.BR
import com.til.tracking.R
import com.til.tracking.databinding.VhTrackingQueryBinding

internal class TrackingQueryViewHolder(
    parent: ViewGroup
) : BaseTrackingViewHolder<VhTrackingQueryBinding>(
    parent,
    R.layout.vh_tracking_query
) {
    init {
        itemView.setOnLongClickListener {
            binding.model?.runCatching {
                simpleLongClickCopy(value)
            }
            return@setOnLongClickListener true
        }
    }

    override fun onBindView(model: Any) {
        binding.setVariable(BR.model, model)
    }
}
