package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Description : 한 데이터 모델 한에 실제 데이터를 받기 위한 데이터 모델
 *
 * Created by juhongmin on 2022/05/15
 */
@Serializable
data class JSendSimpleListWithMeta<T : Any, M : MetaEntity>(
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
        val list: List<T> = listOf(),
        @SerialName("meta")
        val meta: M? = null
    )

    val payload: List<T>
        get() = depthData?.list ?: listOf()
    val meta: M?
        get() = depthData?.meta
}