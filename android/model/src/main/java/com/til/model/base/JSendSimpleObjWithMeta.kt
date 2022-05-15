package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Description :
 *
 * Created by juhongmin on 2022/05/15
 */
@Serializable
data class JSendSimpleObjWithMeta<T : Any, M : MetaEntity>(
    @SerialName("status")
    val isSuccess: Boolean = true,
    @SerialName("message")
    val message: String? = null,
    @SerialName("data")
    val depthData: Payload<T, M>? = null
) {
    @Serializable
    data class Payload<T : Any, M : MetaEntity>(
        @SerialName("payload")
        val obj: T? = null,
        @SerialName("meta")
        val meta: M? = null
    )

    val payload: T
        get() = depthData?.obj ?: throw NullPointerException("Data is Null")
    val meta: M?
        get() = depthData?.meta
}