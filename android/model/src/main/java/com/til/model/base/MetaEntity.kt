package com.til.model.base

import kotlinx.serialization.Serializable

/**
 * Description : Meta 데이터 모델 클래스
 * status: true,
 * data: {
 *  [meta]: {
 *
 *  }
 * }
 *
 * Created by juhongmin on 2022/01/11
 */
@Serializable
data class MetaEntity(
    val limitSize: Int = -1
)