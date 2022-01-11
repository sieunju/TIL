package com.til.model.base

import kotlinx.serialization.Serializable

/**
 * Description : Base Response
 *
 * Created by juhongmin on 2022/01/11
 */
@Serializable
open class BaseResponse<out T : Any>(
    val data: T? = null,
    val isSuccess: Boolean = true
)
