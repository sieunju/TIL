package com.hmju.domain.repository

import com.til.model.base.CustomMetaEntity
import com.til.model.base.JSend
import com.til.model.base.JSendBaseResponse
import com.til.model.base.JSendListWithMeta
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
    fun fetchGoods(params: GoodsParamMap): Single<JSendListWithMeta<GoodsEntity, CustomMetaEntity>>

    fun fetchTest(): Single<JSend<TestEntity>>

    fun postLike(body: LikeRequestBody): Single<JSend<LikeEntity>>

    fun deleteLike(id: Long): Single<JSend<LikeEntity>>
}
