package com.til.model.goods

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/11
 */
@Serializable
data class GoodsEntity(
    val id: Int = 0,
    val title: String = "",
    val message: String = "",
    val imagePath: String = ""
)