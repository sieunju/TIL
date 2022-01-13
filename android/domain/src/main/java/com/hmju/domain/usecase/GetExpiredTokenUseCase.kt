package com.hmju.domain.usecase

import com.hmju.domain.repository.AuthRepository
import com.til.model.auth.TokenEntity
import com.til.model.base.JSendResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/13
 */
class GetExpiredTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke() : Single<JSendResponse<TokenEntity>> {
        return authRepository.tokenExpired()
    }
}