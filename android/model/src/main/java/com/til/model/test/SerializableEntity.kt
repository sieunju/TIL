package com.til.model.test

import java.io.Serializable

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/19
 */
data class SerializableEntity(
    val title: String,
    val uid: Long
) : Serializable