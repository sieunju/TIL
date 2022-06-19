package com.til.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Description : Base JSend 데이터 모델 클래스
 *
 * Created by juhongmin on 2022/06/19
 */
@Serializable
open class BaseJSend {
    @SerialName("status")
    val isSuccess: Boolean = false

    @SerialName("message")
    val message: String? = null
}