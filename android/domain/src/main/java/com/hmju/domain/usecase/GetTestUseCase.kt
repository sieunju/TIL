package com.hmju.domain.usecase

import com.hmju.domain.repository.GoodsRepository
import com.til.model.base.JSendObj
import com.til.model.test.TestEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetTestUseCase @Inject constructor(
    private val goodsRepository: GoodsRepository
) {
    operator fun invoke(): Single<JSendObj<TestEntity>> {
        return goodsRepository.fetchTest()
    }
}