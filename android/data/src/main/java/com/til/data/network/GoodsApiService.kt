package com.til.data.network

import com.til.model.base.JSendListResponse
import com.til.model.base.JSendResponse
import com.til.model.goods.GoodsEntity
import com.til.model.params.GoodsParamMap
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Description : 상품 API 서비스
 *
 * Created by juhongmin on 2022/01/11
 */
interface GoodsApiService {
    @GET("/api/goods")
    fun fetchGoods(
        @QueryMap params: GoodsParamMap
    ): Single<JSendResponse<JSendListResponse<GoodsEntity>>>
}