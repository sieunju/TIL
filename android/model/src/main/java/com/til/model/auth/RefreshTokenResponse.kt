package com.til.model.auth

import com.til.model.base.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
class RefreshTokenResponse : BaseResponse<TokenEntity>()
