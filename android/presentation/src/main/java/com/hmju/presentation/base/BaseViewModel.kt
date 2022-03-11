package com.hmju.presentation.base

import androidx.lifecycle.ViewModel
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnResumed
import com.hmju.lifecycle.OnStopped
import com.hmju.lifecycle.OnViewCreated
import com.hmju.presentation.lifecycle.LifecycleController
import com.hmju.presentation.lifecycle.LifecycleObserver
import com.hmju.presentation.lifecycle.RxLifecycleDelegate
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * Description : BaseViewModel
 *
 * Created by juhongmin on 2022/02/26
 */
open class BaseViewModel : ViewModel(), RxLifecycleDelegate {

    protected val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }
    val lifecycleController: LifecycleController by lazy { LifecycleController() }

    override fun LifecycleObserver.unaryPlus() {
        lifecycleController += this
    }

    /**
     * [OnCreated], [OnResumed], [OnStopped], [OnViewCreated]
     * 으로 선언된 함수를 실행 하는 함수
     */
    inline fun <reified T : Annotation> performLifecycle() {
        javaClass.methods.forEach { method ->
            if (method.isAnnotationPresent(T::class.java)) {
                runCatching {
                    method.invoke(this)
                }
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
