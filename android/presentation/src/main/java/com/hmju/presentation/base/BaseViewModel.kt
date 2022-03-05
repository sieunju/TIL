package com.hmju.presentation.base

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import com.hmju.presentation.lifecycle.LifecycleController
import com.hmju.presentation.lifecycle.LifecycleObserver
import com.hmju.presentation.lifecycle.Resume
import com.hmju.presentation.lifecycle.RxLifecycleDelegate
import io.reactivex.rxjava3.disposables.CompositeDisposable
import timber.log.Timber

/**
 * Description : BaseViewModel
 *
 * Created by juhongmin on 2022/02/26
 */
open class BaseViewModel : ViewModel(), RxLifecycleDelegate {

    protected val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }
    val lifecycleController : LifecycleController by lazy { LifecycleController() }

    override fun LifecycleObserver.unaryPlus() {
        lifecycleController += this
    }

    @CallSuper
    open fun onCreate() {}

    fun performResumeDisposable() {
        javaClass.methods.forEach { method ->
            if(method.isAnnotationPresent(Resume::class.java)) {
                Timber.d("Resume 이있는 함수 ${method.name}")
            }
        }
    }

    fun clearDisposable() {
        compositeDisposable.clear()
    }

    override fun onCleared() {
        super.onCleared()
        if (compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}
