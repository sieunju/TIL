package com.hmju.domain.usecase

import com.hmju.domain.repository.GoodsRepository
import com.til.model.base.JSend
import com.til.model.test.TestEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetTestUseCase @Inject constructor(
    private val goodsRepository: GoodsRepository
) {
    operator fun invoke(): Single<JSend<TestEntity>> {
        return goodsRepository.fetchTest()
    }
}