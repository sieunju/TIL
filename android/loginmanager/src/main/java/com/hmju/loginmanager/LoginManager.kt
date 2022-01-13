package com.hmju.loginmanager

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/12
 */
interface LoginManager {
    fun setToken(token: String)
    fun getToken(): String
}