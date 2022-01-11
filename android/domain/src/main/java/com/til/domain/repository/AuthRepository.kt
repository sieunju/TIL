package com.til.domain.repository

import com.til.model.auth.ExpiredTokenResponse
import com.til.model.auth.RefreshTokenResponse
import io.reactivex.rxjava3.core.Single

/**
 * Description : 사용자 인증 Repository Class
 *
 * Created by juhongmin on 2022/01/12
 */
interface AuthRepository {
    fun tokenRefresh(): Single<RefreshTokenResponse>
    fun tokenExpired(): Single<ExpiredTokenResponse>
}