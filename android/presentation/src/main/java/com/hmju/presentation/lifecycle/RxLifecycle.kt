package com.hmju.presentation.lifecycle

import io.reactivex.rxjava3.disposables.Disposable
import timber.log.Timber

/**
 * Description : ViewModel 에서 Activity or Fragment Lifecycle
 * 에 대한 처리를 할 수 있도록 도와주는 클래스
 *
 * Created by juhongmin on 2022/02/27
 */
typealias DisposableFunction = () -> Disposable

fun onInit(function: DisposableFunction): RxLifecycle = RxLifecycle().init(function)

fun onVisible(function: DisposableFunction): RxLifecycle = RxLifecycle().visible(function)

class RxLifecycle : LifecycleObserver {
    private var onInit: DisposableFunction? = null
    private var initDisposable: Disposable? = null
    private var onVisible: DisposableFunction? = null
    private var visibleDisposable: Disposable? = null

    fun init(init: DisposableFunction): RxLifecycle {
        this.onInit = init
        return this
    }

    fun visible(visible: DisposableFunction): RxLifecycle {
        this.onVisible = visible
        return this
    }

    override fun onInit() {
        Timber.d("onInit")
        initDisposable = this.onInit?.invoke()
    }

    override fun onVisible() {
        Timber.d("onVisible")
        visibleDisposable = this.onVisible?.invoke()
    }

    override fun onInvisible() {
        Timber.d("onInvisible ${visibleDisposable?.isDisposed}")
        if(visibleDisposable?.isDisposed == false) {
            visibleDisposable?.dispose()
        }
    }

    override fun onRelease() {
        Timber.d("onRelease ${initDisposable?.isDisposed}")
        if(initDisposable?.isDisposed == false) {
            initDisposable?.dispose()
        }
    }
}