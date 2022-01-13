package com.til.model.base

import kotlinx.serialization.Serializable

/**
 * Description : 리스트 형태의 Jsend 형식
 * status: true,
 * data: {
 * [payload]: list,
 * [meta]: {
 *      limitSize: 30
 *  }
 * }
 * Created by juhongmin on 2022/01/11
 */
@Serializable
data class JSendListResponse<T : Any>(
    val payload : List<T> = listOf(),
    val meta: MetaEntity = MetaEntity()
)