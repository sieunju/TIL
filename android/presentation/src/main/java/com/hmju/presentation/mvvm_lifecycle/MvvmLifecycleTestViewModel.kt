package com.hmju.presentation.mvvm_lifecycle

import com.hmju.loginmanager.LoginManager
import com.hmju.presentation.base.BaseViewModel
import com.hmju.presentation.lifecycle.OnResumed
import com.hmju.presentation.lifecycle.OnStopped
import com.til.rxbus.TestBusEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/27
 */
@HiltViewModel
class MvvmLifecycleTestViewModel @Inject constructor(
    private val loginManager: LoginManager
) : BaseViewModel() {

    fun onRandomToken() {
        loginManager.setToken("Token ${System.currentTimeMillis()}")
    }

    fun onClick1() {
        TestBusEvent.publish("테스트 버튼 클릭 ${System.currentTimeMillis()}")
    }

    @OnResumed
    fun testResumeOne() {
        Timber.d("resume One")
        loginManager.rxIsLogin()
            .subscribeOn(Schedulers.computation())
            .subscribe({
                Timber.d("Is Login $it")
            }, {

            })
    }

    @OnResumed
    fun testResumeTwo() {
        Timber.d("resume Two")
    }

    @OnStopped
    fun testOnStopped(){
        Timber.d("stopped ")
    }
}
