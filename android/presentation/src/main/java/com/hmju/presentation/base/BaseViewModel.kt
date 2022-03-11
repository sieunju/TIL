package com.hmju.presentation.base

import androidx.lifecycle.ViewModel
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnResumed
import com.hmju.lifecycle.OnStopped
import com.hmju.lifecycle.OnViewCreated
import com.hmju.presentation.lifecycle.*
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
     * OnCreated 선언된 함수를 실행 하는 함수
     * @see OnCreated
     */
    fun performOnCreated() {
        javaClass.methods.forEach { method ->
            if (method.isAnnotationPresent(OnCreated::class.java)) {
                runCatching {
                    method.invoke(this)
                }
            }
        }
    }

    /**
     * onResumed 선언된 함수를 실행 하는 함수
     * @see OnResumed
     */
    fun performOnResumed() {
        javaClass.methods.forEach { method ->
            if (method.isAnnotationPresent(OnResumed::class.java)) {
                runCatching {
                    method.invoke(this)
                }
            }
        }
    }

    /**
     * onStopped 선언된 함수를 실행 하는 함수
     * @see OnStopped
     */
    fun performOnStopped() {
        javaClass.methods.forEach { method ->
            if (method.isAnnotationPresent(OnStopped::class.java)) {
                runCatching {
                    method.invoke(this)
                }
            }
        }
    }

    /**
     * Fragment 에서 OnViewCreated 가 선언된 함수를 실행 하는 함수
     * @see OnViewCreated
     */
    fun performOnViewCreated() {
        javaClass.methods.forEach { method ->
            if (method.isAnnotationPresent(OnViewCreated::class.java)) {
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
