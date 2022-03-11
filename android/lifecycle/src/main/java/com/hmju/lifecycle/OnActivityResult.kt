package com.hmju.lifecycle

/**
 * Description : onActivityResult 에 대한 값을 ViewModel 에서 받을수 있도록 처리하는
 * Annotation Class
 *
 * Created by juhongmin on 2022/03/11
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class OnActivityResult(val code: Int = -1)
