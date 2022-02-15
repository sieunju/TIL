package com.til.data.interceptor

import android.util.Log
import com.hmju.loginmanager.LoginManager
import com.til.data.NetworkConfig
import com.til.data.network.RefreshTokenApiService
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

/**
 * Description : Token 만료시 갱신 처리하는 클래스
 *
 * Created by juhongmin on 2022/01/12
 */
class TokenAuthenticator(
    private val loginManager: LoginManager,
    private val apiService: RefreshTokenApiService
) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        // Token Expired
        Log.d("HTTPLogger", "TokenAuthenticator ${response.code}")
        return if (response.code == 401) {
            val tokenResponse = apiService.tokenRefresh().blockingGet()
            // Token 저장
            Log.d("HTTPLogger", "Refresh Token ${tokenResponse.data}")
            loginManager.setToken(tokenResponse.data?.obj?.token ?: "")
            response.request.newBuilder().apply {
                header(NetworkConfig.HEADER_KEY_ACCEPT, NetworkConfig.HEADER_VAL_ACCEPT)
                header(NetworkConfig.HEADER_KEY_CONTENT, NetworkConfig.HEADER_VAL_CONTENT)
                header(NetworkConfig.HEADER_KEY_TOKEN, loginManager.getToken())
            }.build()
        } else {
            Log.d("JLogger", "TokenAuthenticator Code ${response.code}")
            null
        }
    }
}