package com.til.data.impl

import com.hmju.domain.repository.GoodsRepository
import com.hmju.likemanager.LikeManager
import com.til.data.network.GoodsApiService
import com.til.model.RxBus
import com.til.model.RxBusEvent
import com.til.model.base.JSendListResponse
import com.til.model.base.JSendResponse
import com.til.model.body.LikeRequestBody
import com.til.model.goods.GoodsEntity
import com.til.model.like.LikeEntity
import com.til.model.params.GoodsParamMap
import com.til.model.test.TestEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Description : Goods Repository 구현체 클래스
 *
 * Created by juhongmin on 2022/01/12
 */
class GoodsRepositoryImpl @Inject constructor(
    private val goodsApiService: GoodsApiService
) : GoodsRepository {
    override fun fetchGoods(params: GoodsParamMap): Single<JSendResponse<JSendListResponse<GoodsEntity>>> {
        return goodsApiService.fetchGoods(params)
    }

    override fun fetchTest(): Single<JSendResponse<TestEntity>> {
        return goodsApiService.fetchTest()
    }

    override fun postLike(body: LikeRequestBody): Single<JSendResponse<LikeEntity>> {
        return goodsApiService.postLike(body).map {
            if (it.data != null) {
                LikeManager.addLike(body.id)
                RxBus.publish(RxBusEvent.SimpleLikeEvent(true, body.id))
            }
            return@map it
        }
    }

    override fun deleteLike(id: Long): Single<JSendResponse<LikeEntity>> {
        return goodsApiService.deleteLike(id).map {
            if (it.data != null) {
                LikeManager.removeLike(id)
                RxBus.publish(RxBusEvent.SimpleLikeEvent(false, id))
            }
            return@map it
        }
    }
}