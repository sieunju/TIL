package com.til.data.qualifiers

import javax.inject.Qualifier

@Qualifier
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION)
annotation class ApiHttpClient