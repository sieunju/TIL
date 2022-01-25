package com.hmju.domain.repository

import com.til.model.base.CustomMetaEntity
import com.til.model.base.JSendListResponse
import com.til.model.base.JSendListWithMetaResponse
import com.til.model.base.JSendResponse
import com.til.model.body.LikeRequestBody
import com.til.model.goods.GoodsEntity
import com.til.model.like.LikeEntity
import com.til.model.params.GoodsParamMap
import com.til.model.test.TestEntity
import io.reactivex.rxjava3.core.Single

/**
 * Description : 상품 Repository Class
 *
 * Created by juhongmin on 2022/01/12
 */
interface GoodsRepository {
    fun fetchGoods(params: GoodsParamMap): Single<JSendResponse<JSendListWithMetaResponse<GoodsEntity,CustomMetaEntity>>>

    fun fetchTest(): Single<JSendResponse<TestEntity>>

    fun postLike(body: LikeRequestBody): Single<JSendResponse<LikeEntity>>

    fun deleteLike(id: Long): Single<JSendResponse<LikeEntity>>
}
