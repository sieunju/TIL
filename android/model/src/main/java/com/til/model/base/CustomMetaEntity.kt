package com.til.model.base

import kotlinx.serialization.Serializable

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/25
 */
@Serializable
data class CustomMetaEntity(
    val customPage: Int = 0
) : MetaEntity()