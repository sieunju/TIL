package com.til.model.auth

import kotlinx.serialization.Serializable


@Serializable
data class TokenEntity(
    val token: String = ""
)
