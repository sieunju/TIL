package com.til.data.impl

import com.til.data.network.AuthApiService
import com.til.domain.repository.AuthRepository
import com.til.model.auth.ExpiredTokenResponse
import com.til.model.auth.RefreshTokenResponse
import io.reactivex.rxjava3.core.Single

/**
 * Description : Auth Repository 구현체 클래스
 *
 * Created by juhongmin on 2022/01/12
 */
class AuthRepositoryImpl(
    private val authApiService: AuthApiService
) :AuthRepository {
    override fun tokenRefresh(): Single<RefreshTokenResponse> {
        return authApiService.tokenRefresh()
    }

    override fun tokenExpired(): Single<ExpiredTokenResponse> {
        return authApiService.tokenExpired()
    }
}