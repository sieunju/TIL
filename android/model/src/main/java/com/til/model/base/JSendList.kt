package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * status: true,
 * data: {
 *  [payload] : []
 * }
 * Created by juhongmin on 2022/02/15
 */
@Serializable
data class JSendList<T : Any>(
    @SerialName("payload")
    val list: List<T> = listOf()
) : JSendBaseEntity()