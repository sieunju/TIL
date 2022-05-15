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
@Deprecated(
    "더이상 사용하지 않는 데이터 모델입니다. JSendSimpleObj 로 사용해주세요",
    replaceWith = ReplaceWith("JSendSimpleObj<Foo>"),
    level = DeprecationLevel.ERROR
)
@JSendSimple
@Serializable
data class JSendListWithMeta<T : Any, M : MetaEntity>(
    @SerialName("payload")
    val list: List<T> = listOf(),
    @SerialName("meta")
    val meta: M? = null
)