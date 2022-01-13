package com.til.model.base

import kotlinx.serialization.Serializable

/**
 * Description : 일반 Data 형태의 JSend Format
 * status: true,
 * [data]: {
 * }
 * Created by juhongmin on 2022/01/11
 */
@Serializable
data class JSendResponse<T : Any>(
    val data: T? = null,
    val isSuccess: Boolean = true
)