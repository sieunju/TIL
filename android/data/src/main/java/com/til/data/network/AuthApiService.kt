package com.til.data.network

import com.til.model.auth.ExpiredTokenResponse
import com.til.model.auth.RefreshTokenResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.POST

/**
 * Description : 사용자 인증 관련 API 서비스
 *
 * Created by juhongmin on 2022/01/11
 */
interface AuthApiService {
    @POST("/api/auth/refresh")
    fun tokenRefresh(): Single<RefreshTokenResponse>

    @POST("api/auth/expired")
    fun tokenExpired(): Single<ExpiredTokenResponse>
}
