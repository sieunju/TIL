package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Description : 중간에 재 가공할 데이터 기본 함수
 *
 * Created by juhongmin on 2022/05/15
 */
@Serializable
open class JSendSimpleBaseEntity {
    @SerialName("status")
    val status: String = ""

    @SerialName("message")
    val message: String? = null

    override fun toString(): String {
        return "JSendSimpleBaseEntity(status=$status, message=$message)"
    }
}