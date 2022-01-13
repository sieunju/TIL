package com.til.data.interceptor

import com.til.data.NetworkConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Description : 토큰 갱신용 Interceptor
 *
 * Created by juhongmin on 2022/01/13
 */
class RefreshTokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val origin = chain.request()
        return chain.proceed(origin.newBuilder().apply {
            header(NetworkConfig.HEADER_KEY_ACCEPT, NetworkConfig.HEADER_VAL_ACCEPT)
            header(NetworkConfig.HEADER_KEY_CONTENT, NetworkConfig.HEADER_VAL_CONTENT)
        }.build())
    }
}