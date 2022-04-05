package com.til.tracking.ui.viewholder

import android.view.ViewGroup
import com.til.tracking.BR
import com.til.tracking.R
import com.til.tracking.databinding.VhTrackingPathBinding

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/03
 */
internal class TrackingPathViewHolder(
    parent: ViewGroup
) : BaseTrackingViewHolder<VhTrackingPathBinding>(
    parent,
    R.layout.vh_tracking_path
) {
    override fun onBindView(model: Any) {
        binding.setVariable(BR.model, model)
    }
}
