package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Description : 리스트 형태의 Jsend 형식
 * status: true,
 * data: {
 * [list]: list,
 * [meta]: {
 *      limitSize: 30
 *  }
 * }
 * Created by juhongmin on 2022/01/25
 */
@Serializable
data class JSendListWithMetaResponse<T : Any, M : MetaEntity>(
    @SerialName("payload")
    val list: List<T> = listOf(),
    @SerialName("meta")
    val meta: M? = null
)
