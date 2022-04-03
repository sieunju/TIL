package com.til.tracking.models

import com.til.tracking.R

internal data class TrackingPathUiModel(
    val path: String? = null
) : BaseTrackingUiModel(R.layout.vh_tracking_path)
