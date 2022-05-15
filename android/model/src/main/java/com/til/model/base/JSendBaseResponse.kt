package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Description : 일반 Data 형태의 JSend Format
 * 모든 데이터 Response 는 해당 데이터 모델을 기반으로 구성해야 한다.
 *
 * status: true,
 * [data]: {
 * }
 * Created by juhongmin on 2022/01/11
 */
@Serializable
data class JSendBaseResponse<T : Any>(
    @SerialName("status")
    val isSuccess: Boolean = true,
    val message: String? = null,
    @SerialName("data")
    val data: T? = null
)