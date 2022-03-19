package com.hmju.loginmanager.impl

import android.content.Context
import android.content.SharedPreferences
import com.hmju.loginmanager.LoginManager
import com.til.rxbus.LoginBusEvent
import com.til.rxbus.LoginEvent
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import kotlin.random.Random

/**
 * Description : 로그인 메니저 구현체 클래스
 *
 * Created by juhongmin on 2022/01/12
 */
class LoginManagerImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : LoginManager {

    private val pref: SharedPreferences =
        context.getSharedPreferences("til_pref", Context.MODE_PRIVATE)

    companion object {
        const val KEY_TOKEN = "user_token"
        const val KEY_NICK_NAME = "user_nick_name"
    }

    private var userToken: String = ""

    override fun setToken(token: String) {
        with(pref.edit()) {
            putString(KEY_TOKEN, token)
            apply()
            // Test
            LoginBusEvent.publish(LoginEvent(Random.nextBoolean(), token))
        }

        userToken = token
    }

    override fun getToken(): String {
        if (userToken.isEmpty()) {
            userToken = pref.getString(KEY_TOKEN, "") ?: ""
        }
        return userToken
    }

    override fun isLogin(): Boolean {
        return getToken().isNotEmpty()
    }

    override fun rxIsLogin(): Single<Boolean> {
        return Single.just(getToken().isNotEmpty())
    }
}