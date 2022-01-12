package com.til.data.impl

import com.til.data.network.GoodsApiService
import com.til.domain.repository.GoodsRepository
import com.til.model.base.JSendListResponse
import com.til.model.base.JSendResponse
import com.til.model.goods.GoodsEntity
import com.til.model.params.GoodsParamMap
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
}