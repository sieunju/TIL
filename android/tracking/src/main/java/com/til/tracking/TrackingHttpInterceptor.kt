package com.til.tracking

import com.til.tracking.entity.TrackingHttpEntity
import com.til.tracking.entity.TrackingRequestEntity
import com.til.tracking.entity.TrackingResponseEntity
import okhttp3.*
import okio.Buffer
import okio.IOException
import java.util.concurrent.TimeUnit

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
        if (TrackingManager.getInstance().isRelease()) {
            return chain.proceed(request)
        }
        val tracking = try {
            TrackingHttpEntity(
                headerMap = toHeaderMap(request.headers),
                path = request.url.encodedPath,
                req = TrackingRequestEntity(
                    query = request.url.query,
                    body = toReqBodyStr(request.body)
                )
            ).apply {
                baseUrl = request.url.host
                method = request.method
            }
        } catch (ex: Exception) {
            null
        }
        val startNs = System.nanoTime()
        val response = try {
            chain.proceed(request)
        } catch (ex: Exception) {
            tracking?.error = ex
            throw ex
        }
        tracking?.let {
            it.res = TrackingResponseEntity(toResBodyString(response.body))
            it.takenTimeMs = response.receivedResponseAtMillis - response.sentRequestAtMillis
            it.code = response.code
        }
        TrackingManager.getInstance().addTracking(tracking)
        return response
    }

    /**
     * Request Header to Map
     */
    private fun toHeaderMap(headers: Headers): Map<String, String> {
        val map = mutableMapOf<String, String>()
        headers.forEach { pair ->
            map[pair.first] = pair.second
        }
        return map
    }

    /**
     * Request Body to String
     */
    private fun toReqBodyStr(body: RequestBody?): String? {
        if (body == null) return null
        return try {
            val buffer = Buffer()
            body.writeTo(buffer)
            buffer.readString(Charsets.UTF_8)
        } catch (ex: Exception) {
            null
        }
    }

    /**
     * Response Body to String
     */
    private fun toResBodyString(body: ResponseBody?): String? {
        if (body == null) return null
        return try {
            body.string()
        } catch (ex: Exception) {
            null
        }
    }
}
