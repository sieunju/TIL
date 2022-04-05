package com.til.tracking.models

import com.til.tracking.R

internal data class TrackingBodyUiModel(
    val body : String = ""
) : BaseTrackingUiModel(R.layout.vh_tracking_body)