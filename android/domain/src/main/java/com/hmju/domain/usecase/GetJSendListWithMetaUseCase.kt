package com.hmju.domain.usecase

import com.hmju.domain.repository.JSendRepository
import com.til.model.base.JSendSimpleListWithMeta
import com.til.model.base.MetaEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetJSendListWithMetaUseCase @Inject constructor(
    private val repository: JSendRepository
) {
    operator fun invoke(): Single<JSendSimpleListWithMeta<String, MetaEntity>> {
        return repository.fetchJSendListWithMeta()
    }
}
