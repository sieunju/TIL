package com.til.data.impl

import com.hmju.domain.repository.AuthRepository
import com.til.data.network.AuthApiService
import com.til.model.auth.TokenEntity
import com.til.model.base.JSend
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Description : Auth Repository 구현체 클래스
 *
 * Created by juhongmin on 2022/01/12
 */
internal class AuthRepositoryImpl @Inject constructor(
    private val authApiService: AuthApiService
) : AuthRepository {
    override fun tokenRefresh(): Single<JSend<TokenEntity>> {
        return authApiService.tokenRefresh()
            .map { it.data ?: throw NullPointerException("Data is Null") }
    }

    override fun tokenExpired(): Single<JSend<TokenEntity>> {
        return authApiService.tokenExpired()
            .map { it.data ?: throw NullPointerException("Data is Null") }
    }
}