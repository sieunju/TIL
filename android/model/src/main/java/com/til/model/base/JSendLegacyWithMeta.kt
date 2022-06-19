package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * status: true,
 * data: {
 *  [payload] : {},
 *  [meta]: {}
 * }
 * Created by juhongmin on 2022/02/15
 */
@Deprecated(
    "더이상 사용하지 않는 데이터 모델입니다. JSendSimpleObj 로 사용해주세요",
    replaceWith = ReplaceWith("JSendSimpleObjWithMeta<Foo>"),
    level = DeprecationLevel.ERROR
)
@Serializable
data class JSendLegacyWithMeta<T : Any, M : MetaEntity>(
    @SerialName("payload")
    val obj: T? = null,
    @SerialName("meta")
    val meta: M? = null
)
