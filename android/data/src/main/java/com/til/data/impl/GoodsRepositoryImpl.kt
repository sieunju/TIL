package com.til.data.impl

import com.til.data.network.GoodsApiService
import com.til.domain.repository.GoodsRepository
import com.til.model.goods.GoodsResponse
import com.til.model.params.GoodsParamMap
import io.reactivex.rxjava3.core.Single

/**
 * Description : Goods Repository 구현체 클래스
 *
 * Created by juhongmin on 2022/01/12
 */
class GoodsRepositoryImpl(
    private val goodsApiService: GoodsApiService
) : GoodsRepository {
    override fun fetchGoods(params: GoodsParamMap): Single<GoodsResponse> {
        return goodsApiService.fetchGoods(params)
    }
}