package com.hmju.presentation.lifecycle

import timber.log.Timber

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/27
 */
class LifecycleController : RxLifecycleDelegate {
    private val observers = mutableListOf<LifecycleObserver>()
    private var state: LifecycleState = LifecycleState.Unknown
    override fun LifecycleObserver.unaryPlus() {
        this@LifecycleController += this
    }

    operator fun plusAssign(observer: LifecycleObserver) {
        observers += observer
        when (state) {
            LifecycleState.Init -> observer.onInit()
            LifecycleState.Release -> observer.onRelease()
            LifecycleState.Visible -> observer.onVisible()
            LifecycleState.InVisible -> observer.onInvisible()
            else -> {}
        }
    }

    fun onInit(){
        observers.forEach { it.onInit() }
        state = LifecycleState.Init
    }

    fun onVisible(){
        observers.forEach { it.onVisible() }
        state = LifecycleState.Visible
    }

    fun onInVisible(){
        observers.forEach { it.onInvisible() }
        state = LifecycleState.InVisible
    }

    fun onRelease(){
        observers.forEach { it.onRelease() }
        state = LifecycleState.Release
    }
}

interface RxLifecycleDelegate {
    operator fun LifecycleObserver.unaryPlus()
}

interface LifecycleObserver {
    fun onInit() = Unit // onCreate
    fun onVisible() = Unit // onStop -> onResume
    fun onInvisible() = Unit // onResume -> onStop
    fun onRelease() = Unit // onDestroy
}

sealed class LifecycleState {
    object Unknown : LifecycleState()
    object Init : LifecycleState()
    object Release : LifecycleState()
    object Visible : LifecycleState()
    object InVisible : LifecycleState()
}