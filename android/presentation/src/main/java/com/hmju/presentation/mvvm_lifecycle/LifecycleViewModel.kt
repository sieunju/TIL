package com.hmju.presentation.mvvm_lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hmju.domain.usecase.GetGoodsUseCase
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnResumed
import com.hmju.lifecycle.OnStopped
import com.hmju.loginmanager.LoginManager
import com.hmju.presentation.base.BaseViewModel
import com.til.model.params.GoodsParamMap
import com.til.rxbus.TestBusEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/26
 */
@HiltViewModel
class LifecycleViewModel @Inject constructor(
    private val loginManager: LoginManager,
    private val goodsUseCase: GetGoodsUseCase
) : BaseViewModel() {

    val moveFragment: MutableLiveData<Unit> by lazy { MutableLiveData() }
    val moveActivity: MutableLiveData<Unit> by lazy { MutableLiveData() }

    private val _text: MutableLiveData<String> by lazy { MutableLiveData() }
    val text: LiveData<String> get() = _text
    private val queryMap: GoodsParamMap by lazy { GoodsParamMap() }

    @OnCreated
    fun onCreate() {
        _text.value = "Hello"
        goodsUseCase(queryMap)
            .subscribe({
                loginManager.setToken(it[0].imagePath)
            }, {

            }).addTo(compositeDisposable)
    }

    @OnResumed
    fun onIsLoginCheck() {
        loginManager.rxIsLogin()
            .subscribeOn(Schedulers.computation())
            .subscribe({
                Timber.d("OnResume Is Login $it")
            }, {

            }).addTo(compositeDisposable)
    }

    @OnResumed
    fun onLoginTokenResume() {
        Timber.d("Resume Token ${loginManager.getToken()}")
    }

    @OnStopped
    fun onStop() {
        loginManager.rxIsLogin()
            .subscribeOn(Schedulers.computation())
            .subscribe({
                Timber.d("onStop Is Login $it")
            }, {

            }).addTo(compositeDisposable)
    }

    fun onTestBusEvent() {
        TestBusEvent.publish("Test Hahah ${System.currentTimeMillis()}")
    }

    fun moveFragment() {
        moveFragment.value = Unit
    }

    fun moveActivity() {
        moveActivity.value = Unit
    }
}
