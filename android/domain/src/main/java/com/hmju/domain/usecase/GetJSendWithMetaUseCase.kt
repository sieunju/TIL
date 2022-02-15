package com.hmju.domain.usecase

import com.hmju.domain.repository.JSendRepository
import com.til.model.base.CustomMetaEntity
import com.til.model.base.JSendBaseResponse
import com.til.model.base.JSendWithMeta
import com.til.model.test.JSendTestEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetJSendWithMetaUseCase @Inject constructor(
    private val repository: JSendRepository
) {
    operator fun invoke(): Single<JSendBaseResponse<JSendWithMeta<JSendTestEntity, CustomMetaEntity>>> {
        return repository.fetchJSendWithMeta()
    }
}
