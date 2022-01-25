package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Description : Meta 형태를 가지고 있는 JSend Format
 * status: true,
 * data: {
 *  [payload] : {
 *  },
 *  [meta] : {
 *  }
 * }
 *
 * Created by juhongmin on 2022/01/25
 */
@Serializable
data class JSendWithMetaResponse<T : Any, M : MetaEntity>(
    @SerialName("payload")
    val data: T? = null,
    @SerialName("meta")
    val meta: M? = null
)