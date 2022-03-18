package com.hmju.loginmanager

import io.reactivex.rxjava3.core.Single

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/12
 */
interface LoginManager {
    fun setToken(token: String)
    fun getToken(): String
    fun isLogin() : Boolean
    fun rxIsLogin() : Single<Boolean>
}