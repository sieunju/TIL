package com.til.data.impl

import com.hmju.domain.repository.GoodsRepository
import com.hmju.likemanager.LikeManager
import com.til.data.network.GoodsApiService
import com.til.model.RxBus
import com.til.model.RxBusEvent
import com.til.model.base.JSendListWithMeta
import com.til.model.base.JSendObj
import com.til.model.body.LikeRequestBody
import com.til.model.goods.GoodsEntity
import com.til.model.like.LikeEntity
import com.til.model.meta.CustomMetaEntity
import com.til.model.params.GoodsParamMap
import com.til.model.test.TestEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Description : Goods Repository 구현체 클래스
 *
 * Created by juhongmin on 2022/01/12
 */
internal class GoodsRepositoryImpl @Inject constructor(
    private val goodsApiService: GoodsApiService
) : GoodsRepository {
    override fun fetchGoods(params: GoodsParamMap): Single<JSendListWithMeta<GoodsEntity, CustomMetaEntity>> {
        return goodsApiService.fetchGoods(params)
    }

    override fun fetchTest(): Single<JSendObj<TestEntity>> {
        return goodsApiService.fetchTest()
    }

    override fun postLike(body: LikeRequestBody): Single<JSendObj<LikeEntity>> {
        return goodsApiService.postLike(body).map {
            if (it.isSuccess) {
                LikeManager.addLike(body.id)
                RxBus.publish(RxBusEvent.SimpleLikeEvent(true, body.id))
            }
            return@map it
        }
    }

    override fun deleteLike(id: Long): Single<JSendObj<LikeEntity>> {
        return goodsApiService.deleteLike(id).map {
            if (it.isSuccess) {
                LikeManager.removeLike(id)
                RxBus.publish(RxBusEvent.SimpleLikeEvent(false, id))
            }
            return@map it
        }
    }
}
