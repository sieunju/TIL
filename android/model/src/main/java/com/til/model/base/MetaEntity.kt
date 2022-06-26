package com.til.model.base

import kotlinx.serialization.Serializable

/**
 * Description : Meta 데이터 모델 클래스
 *
 * Created by juhongmin on 2022/01/11
 */
@Serializable
open class MetaEntity {
    val limitSize: Int = -1
    val notice: String = ""
}