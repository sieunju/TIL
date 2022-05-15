package com.hmju.domain.repository

import com.til.model.meta.CustomMetaEntity
import com.til.model.base.JSendSimpleListWithMeta
import com.til.model.base.JSendSimpleObj
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
    fun fetchGoods(params: GoodsParamMap): Single<JSendSimpleListWithMeta<GoodsEntity, CustomMetaEntity>>

    fun fetchTest(): Single<JSendSimpleObj<TestEntity>>

    fun postLike(body: LikeRequestBody): Single<JSendSimpleObj<LikeEntity>>

    fun deleteLike(id: Long): Single<JSendSimpleObj<LikeEntity>>
}
