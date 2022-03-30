package com.til.tracking

import com.til.tracking.entity.TrackingHttpEntity
import com.til.tracking.entity.TrackingRequestEntity
import com.til.tracking.entity.TrackingResponseEntity
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Response
import okio.IOException

/**
 * Description : Http 정보 추적하는 Interceptor
 *
 * Created by juhongmin on 2022/03/29
 */
class TrackingHttpInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        // 릴리즈 Skip
        if(TrackingManager.getInstance().isRelease()) {
            return chain.proceed(request)
        }
        val tracking = try {
            TrackingHttpEntity(
                headerMap = toHeaderMap(request.headers),
                path = request.url.encodedPath,
                req = TrackingRequestEntity(
                    query = request.url.query,
                    body = request.body.toString()
                )
            ).apply {
                baseUrl = request.url.host
                method = request.method
            }
        } catch (ex : Exception) {
            null
        }
        val response = try {
            chain.proceed(request)
        } catch (ex: Exception) {
            tracking?.error = ex
            throw ex
        }
        tracking?.let {
            it.res = TrackingResponseEntity(response.body.toString())
            it.takenTimeMs = response.receivedResponseAtMillis
            it.code = response.code
        }
        TrackingManager.getInstance().addTracking(tracking)
        return response
    }

    private fun toHeaderMap(headers: Headers): Map<String, String> {
        val map = mutableMapOf<String, String>()
        headers.forEach { pair ->
            map[pair.first] = pair.second
        }
        return map
    }
}