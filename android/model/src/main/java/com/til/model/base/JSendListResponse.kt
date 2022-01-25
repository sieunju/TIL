package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Description : 리스트 형태의 Jsend 형식
 * status: true,
 * data: {
 * [list]: list
 * }
 * Created by juhongmin on 2022/01/11
 */
@Serializable
data class JSendListResponse<T : Any>(
    @SerialName("payload")
    val list: List<T> = listOf()
)
