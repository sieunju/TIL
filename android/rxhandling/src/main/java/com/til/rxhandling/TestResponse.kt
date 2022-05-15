package com.til.rxhandling

import kotlinx.serialization.Serializable

/**
 * Description :
 *
 * Created by juhongmin on 2022/05/15
 */
@Serializable
data class TestResponse(
    val isSuccess: Boolean = true,
    val message: String? = null,
) {

}