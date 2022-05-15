package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Description :
 *
 * Created by juhongmin on 2022/05/15
 */
@Serializable
data class JSendSimpleList<T : Any>(
    @SerialName("status")
    val isSuccess: Boolean = true,
    @SerialName("message")
    val message: String? = null,
    @SerialName("data")
    private val depthData: Payload<T>? = null
) {
    @Serializable
    data class Payload<T : Any>(
        @SerialName("payload")
        val list: List<T> = listOf()
    )

    val payload: List<T>
        get() = depthData?.list ?: listOf()
}
