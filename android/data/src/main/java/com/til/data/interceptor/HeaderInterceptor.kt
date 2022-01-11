package com.til.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/12
 */
class HeaderInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val origin = chain.request()
        return chain.proceed(origin.newBuilder().apply {
            header("Accept", "application/json")
            header("Content-Type", "application/json")
            header("Token","token..")
        }.build())
    }
}