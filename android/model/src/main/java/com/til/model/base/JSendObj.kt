package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Description : 개선된 방식의 JSend Object Data Model
 *
 * Created by juhongmin on 2022/05/15
 */
@Serializable
data class JSendObj<T : Any>(
    @SerialName("data")
    private val depthData: Payload<T>? = null
) : BaseJSend() {
    @Serializable
    data class Payload<T : Any>(
        @SerialName("payload")
        val obj: T? = null
    )

    val isValid: Boolean
        get() = depthData?.obj != null

    val payload: T
        get() = depthData?.obj ?: throw NullPointerException("Data is Null")
}