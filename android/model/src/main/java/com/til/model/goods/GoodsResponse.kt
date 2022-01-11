package com.til.model.goods

import com.til.model.base.BaseListResponse
import com.til.model.base.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
class GoodsResponse : BaseResponse<BaseListResponse<GoodsEntity>>()