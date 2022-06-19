package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Description : 개선된 방식의 JSend Object With Meta Data Model
 *
 * Created by juhongmin on 2022/05/15
 */
@Serializable
data class JSendObjWithMeta<T : Any, M : MetaEntity>(
    @SerialName("data")
    private val depthData: Payload<T, M>? = null
) : BaseJSend() {
    @Serializable
    data class Payload<T : Any, M : MetaEntity>(
        @SerialName("payload")
        val obj: T? = null,
        @SerialName("meta")
        val meta: M? = null
    )

    val isValid: Boolean
        get() = depthData?.obj != null // true 유효현 데이터 상태

    val payload: T
        get() = depthData?.obj ?: throw NullPointerException("Data is Null")
    val meta: M?
        get() = depthData?.meta
}