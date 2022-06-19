package com.til.model.error

/**
 * Description : JSend 규칙에서 data or data in payload 값이 없는 경우
 *
 * Created by juhongmin on 2022/06/18
 */
data class JSendInvalidPayloadException(val msg: String? = null, val error: Throwable? = null) :
    RuntimeException(msg, error)
