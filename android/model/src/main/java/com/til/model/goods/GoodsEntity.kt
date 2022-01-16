package com.til.model.goods

import kotlinx.serialization.Serializable

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/11
 */
@Serializable
data class GoodsEntity(
    val id: Long = 0,
    val title: String = "",
    val message: String = "",
    val imagePath: String = ""
)