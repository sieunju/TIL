package com.hmju.domain.usecase

import com.hmju.domain.repository.GoodsRepository
import com.til.model.goods.GoodsEntity
import com.til.model.params.GoodsParamMap
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class GetGoodsUseCase @Inject constructor(
    private val repository: GoodsRepository
) {
    operator fun invoke(params: GoodsParamMap): Single<List<GoodsEntity>> {
        return repository.fetchGoods(params)
            .map { it.data?.list ?: emptyList() }
    }
}