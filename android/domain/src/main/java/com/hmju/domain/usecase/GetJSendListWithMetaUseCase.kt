package com.hmju.domain.usecase

import com.hmju.domain.repository.JSendRepository
import com.til.model.base.CustomMetaEntity
import com.til.model.base.JSendListWithMetaResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetJSendListWithMetaUseCase @Inject constructor(
    private val repository: JSendRepository
) {
    operator fun invoke(): Single<JSendListWithMetaResponse<List<String>, CustomMetaEntity>> {
        return repository.fetchJSendListWithMeta()
    }
}

