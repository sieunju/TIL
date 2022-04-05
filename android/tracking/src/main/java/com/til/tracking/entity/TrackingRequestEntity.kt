package com.til.tracking.entity

/**
 * Description : HTTP Request Data Entity
 *
 * Created by juhongmin on 2022/03/30
 */
internal data class TrackingRequestEntity(
    val query : String? = null,
    val body : String? = null
)
