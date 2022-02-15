package com.hmju.domain.usecase

import com.hmju.domain.repository.JSendRepository
import com.til.model.base.JSend
import com.til.model.base.JSendBaseResponse
import com.til.model.test.JSendTestEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetJSendUseCase @Inject constructor(
    private val repository: JSendRepository
) {
    operator fun invoke(): Single<JSendBaseResponse<JSend<JSendTestEntity>>> {
        return repository.fetchJSend()
    }
}
