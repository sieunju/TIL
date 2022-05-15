package com.til.data.network

import com.til.model.base.*
import com.til.model.meta.CustomMetaEntity
import com.til.model.body.LikeRequestBody
import com.til.model.goods.GoodsEntity
import com.til.model.like.LikeEntity
import com.til.model.params.GoodsParamMap
import com.til.model.test.TestEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

/**
 * Description : 상품 API 서비스
 *
 * Created by juhongmin on 2022/01/11
 */
interface GoodsApiService {
    @GET("/api/goods")
    fun fetchGoods(
        @QueryMap(encoded = true) params: GoodsParamMap
    ): Single<JSendSimpleListWithMeta<GoodsEntity, CustomMetaEntity>>

    @GET("/api/test")
    fun fetchTest(): Single<JSendSimpleObj<TestEntity>>

    @POST("/api/like")
    fun postLike(
        @Body body: LikeRequestBody
    ): Single<JSendSimpleObj<LikeEntity>>

    @DELETE("/api/like/{id}")
    fun deleteLike(
        @Path("id") id: Long
    ): Single<JSendSimpleObj<LikeEntity>>
}
