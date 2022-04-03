package com.til.tracking.ui.viewholder

import android.view.ViewGroup
import com.til.tracking.BR
import com.til.tracking.R
import com.til.tracking.databinding.VhTrackingHeaderBinding

internal class TrackingHeaderViewHolder(
    parent: ViewGroup
) : BaseTrackingViewHolder<VhTrackingHeaderBinding>(parent, R.layout.vh_tracking_header) {

    override fun onBindView(model: Any) {
        binding.setVariable(BR.model, model)
    }
}
