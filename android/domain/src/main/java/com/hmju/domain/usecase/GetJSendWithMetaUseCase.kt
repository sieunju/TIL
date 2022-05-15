package com.hmju.domain.usecase

import com.hmju.domain.repository.JSendRepository
import com.til.model.meta.CustomMetaEntity
import com.til.model.base.JSendSimpleObjWithMeta
import com.til.model.test.JSendTestEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetJSendWithMetaUseCase @Inject constructor(
    private val repository: JSendRepository
) {
    operator fun invoke(): Single<JSendSimpleObjWithMeta<JSendTestEntity, CustomMetaEntity>> {
        return repository.fetchJSendWithMeta()
    }
}
