package com.hmju.domain.usecase

import com.hmju.domain.repository.AuthRepository
import com.til.model.auth.TokenEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetExpiredTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(): Single<TokenEntity> {
        return authRepository.tokenExpired()
    }
}