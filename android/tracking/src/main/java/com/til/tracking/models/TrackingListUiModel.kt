package com.til.tracking.models

import com.til.tracking.R
import com.til.tracking.entity.TrackingHttpEntity

internal data class TrackingListUiModel(
    val item: TrackingHttpEntity
) : BaseTrackingUiModel(R.layout.vh_child_tracking)
