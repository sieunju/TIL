package com.til.tracking.ui.viewholder

import android.view.ViewGroup
import com.til.tracking.BR
import com.til.tracking.R
import com.til.tracking.databinding.VhTrackingTitleBinding

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/03
 */
internal class TrackingTitleViewHolder(
    parent: ViewGroup
) : BaseTrackingViewHolder<VhTrackingTitleBinding>(
    parent,
    R.layout.vh_tracking_title
) {
    override fun onBindView(model: Any) {
        binding.setVariable(BR.model, model)
    }
}
