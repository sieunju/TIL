package com.til.data.impl

import com.hmju.domain.repository.AuthRepository
import com.til.data.network.AuthApiService
import com.til.model.auth.TokenEntity
import com.til.model.base.JSendResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Description : Auth Repository 구현체 클래스
 *
 * Created by juhongmin on 2022/01/12
 */
class AuthRepositoryImpl @Inject constructor(
    private val authApiService: AuthApiService
) : AuthRepository {
    override fun tokenRefresh(): Single<JSendResponse<TokenEntity>> {
        return authApiService.tokenRefresh()
    }

    override fun tokenExpired(): Single<JSendResponse<TokenEntity>> {
        return authApiService.tokenExpired()
    }
}