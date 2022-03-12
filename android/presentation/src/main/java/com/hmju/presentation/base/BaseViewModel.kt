package com.hmju.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hmju.lifecycle.*
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

    companion object {
        const val REQ_CODE = "req_code"
    }

    protected val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }
    val lifecycleController: LifecycleController by lazy { LifecycleController() }

    val startActivity: MutableLiveData<MovePage> by lazy { MutableLiveData() }
    val startActivityResult: MutableLiveData<MovePage> by lazy { MutableLiveData() }

    @Deprecated(
        message = "ViewModel 에서 Annotation 으로 처리하는것으로 변경했습니다.",
        replaceWith = ReplaceWith("OnCreated, OnResumed, OnStopped")
    )
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
