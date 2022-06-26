package com.hmju.domain.usecase

import com.hmju.domain.repository.JSendRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/06/19
 */
class GetErrorTestUseCase @Inject constructor(
    private val repository: JSendRepository
) {
    operator fun invoke(): Single<String> {
        return repository.fetchErrorTest()
            .map { it.payload }
    }
}