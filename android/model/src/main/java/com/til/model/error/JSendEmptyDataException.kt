package com.til.model.error

/**
 * Description : JSend 규칙에서 data 값이 없지만,
 * status 값이 success 인경우 리턴하는 Exception
 *
 * Created by juhongmin on 2022/06/19
 */
data class JSendEmptyDataException(val msg: String? = null) : RuntimeException(msg)
