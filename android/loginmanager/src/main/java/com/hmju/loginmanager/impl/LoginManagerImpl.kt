package com.hmju.loginmanager.impl

import android.content.Context
import android.content.SharedPreferences
import com.hmju.loginmanager.LoginManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

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
        }

        userToken = token
    }

    override fun getToken(): String {
        if (userToken.isEmpty()) {
            userToken = pref.getString(KEY_TOKEN, "") ?: ""
        }
        return userToken
    }
}