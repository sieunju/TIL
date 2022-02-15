package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * status: true,
 * data: {
 *  [payload] : {}
 * }
 * Created by juhongmin on 2022/02/15
 */
@Serializable
data class JSend<T : Any>(
    @SerialName("payload")
    val obj: T? = null
)