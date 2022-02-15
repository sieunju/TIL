package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * status: true,
 * data: {
 *  [payload]: [],
 *  [meta]: {}
 * }
 * Created by juhongmin on 2022/02/15
 */
@Serializable
data class JSendListWithMeta<T : Any, M : MetaEntity>(
    @SerialName("payload")
    val list: List<T> = listOf(),
    @SerialName("meta")
    val meta: M? = null
)