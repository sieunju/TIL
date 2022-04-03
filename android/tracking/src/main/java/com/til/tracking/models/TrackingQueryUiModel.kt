package com.til.tracking.models

import com.til.tracking.R

internal data class TrackingQueryUiModel(
    val key: String = "",
    val value: String = ""
) : BaseTrackingUiModel(R.layout.vh_tracking_query)
