package com.til.data

/**
 * Description : Network 설정 정의 클래스
 *
 * Created by juhongmin on 2022/01/12
 */
object NetworkConfig {
    const val CONNECT_TIME_OUT = 5000L
    const val READ_TIME_OUT = 5000L
    const val WRITE_TIME_OUT = 5000L
    const val HEADER_KEY_ACCEPT = "accept"
    const val HEADER_VAL_ACCEPT = "application/json"
    const val HEADER_KEY_CONTENT = "Content-Type"
    const val HEADER_VAL_CONTENT = "application/json"
    const val HEADER_KEY_TOKEN = "Token"

    const val BASE_URL: String = "https://til.qtzz.synology.me"
}