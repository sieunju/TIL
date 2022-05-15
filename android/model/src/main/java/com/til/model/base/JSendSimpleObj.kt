package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Description : 개선된 방식의 JSend Object Data Model
 *
 * Created by juhongmin on 2022/05/15
 */
@Serializable
data class JSendSimpleObj<T : Any>(
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
        val obj: T? = null
    )

    val payload: T
        get() = depthData?.obj ?: throw NullPointerException("Data is Null")
}