package com.til.data.network

import com.til.model.auth.TokenEntity
import com.til.model.base.JSend
import com.til.model.base.JSendBaseResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.POST

/**
 * Description : 사용자 인증 관련 API 서비스
 *
 * Created by juhongmin on 2022/01/11
 */
interface AuthApiService {
    @POST("/api/auth/refresh")
    fun tokenRefresh(): Single<JSendBaseResponse<JSend<TokenEntity>>>

    @POST("/api/auth/expired")
    fun tokenExpired(): Single<JSendBaseResponse<JSend<TokenEntity>>>
}
