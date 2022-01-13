package com.hmju.domain.usecase

import com.hmju.domain.repository.AuthRepository
import com.til.model.auth.TokenEntity
import com.til.model.base.JSendResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetRefreshTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke() : Single<TokenEntity> {
        return authRepository.tokenRefresh()
    }
}