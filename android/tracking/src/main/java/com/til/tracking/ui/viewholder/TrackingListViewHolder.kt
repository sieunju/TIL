package com.til.tracking.ui.viewholder

import android.view.ViewGroup
import com.til.tracking.BR
import com.til.tracking.R
import com.til.tracking.databinding.VhChildTrackingBinding
import com.til.tracking.rx.TrackingDetailEvent
import timber.log.Timber

internal class TrackingListViewHolder(
    parent: ViewGroup
) : BaseTrackingViewHolder<VhChildTrackingBinding>(
    parent,
    R.layout.vh_child_tracking
) {
    init {
        itemView.setOnClickListener {
            binding.model?.runCatching {
                TrackingDetailEvent.publish(item)
            }?.onFailure {
                Timber.d("ERROR $it")
            }
        }
    }

    override fun onBindView(model: Any) {
        binding.setVariable(BR.model, model)
    }
}
