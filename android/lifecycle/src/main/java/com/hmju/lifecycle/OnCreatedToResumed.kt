package com.hmju.lifecycle

/**
 * Description : Activity or Fragment 에서
 * Lifecycle onResume 상태일때 호출
 * onCreate -> onResume,
 * onStop -> onResume
 * BaseViewModel 상속 받은 ViewModel 에서만 사용 가능
 * Created by juhongmin on 2022/04/20
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class OnCreatedToResumed
