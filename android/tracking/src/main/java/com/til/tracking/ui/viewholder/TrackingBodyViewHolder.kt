package com.til.tracking.ui.viewholder

import android.view.ViewGroup
import com.til.tracking.BR
import com.til.tracking.R
import com.til.tracking.databinding.VhTrackingBodyBinding

class TrackingBodyViewHolder(parent: ViewGroup) : BaseTrackingViewHolder<VhTrackingBodyBinding>(
    parent,
    R.layout.vh_tracking_body
) {
    override fun onBindView(model: Any) {
        binding.setVariable(BR.model, model)
    }
}
