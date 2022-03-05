package com.hmju.presentation.lifecycle

/**
 * Description : Activity or Fragment
 * onStop -> onResume 호출
 * onCreate -> onResume 인 경우에는 호출 X
 * Created by juhongmin on 2022/03/01
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Resume
