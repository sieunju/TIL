package com.hmju.presentation.mvvm_lifecycle

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hmju.domain.usecase.GetGoodsUseCase
import com.hmju.lifecycle.*
import com.hmju.loginmanager.LoginManager
import com.hmju.presentation.IntentKey
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

    private val _activityResult: MutableLiveData<String> by lazy { MutableLiveData() }
    val activityResult: LiveData<String> get() = _activityResult
    private val queryMap: GoodsParamMap by lazy { GoodsParamMap() }

    @OnCreated
    fun onCreate() {
        activityStack.value = getActivityStackStr()
        fragmentStack.value = getFragmentStackStr()
        goodsUseCase(queryMap)
            .subscribe({
                loginManager.setToken(it[0].imagePath)
            }, {
            }).addTo(compositeDisposable)
    }

    @OnResumed
    fun onResume() {
        activityStack.value = getActivityStackStr()
        fragmentStack.value = getFragmentStackStr()
    }

    fun move200Page() {
        movePage(
            MovePageEvent(
                MvvmLifecycleTest2Activity::class.java,
                bundle = Bundle().apply {
                    putString(IntentKey.TOKEN, loginManager.getToken())
                },
                requestCode = 200
            )
        )
    }

    fun move201Page() {
        movePage(
            MovePageEvent(
                MvvmLifecycleTest2Activity::class.java,
                bundle = Bundle().apply {
                    putLong(IntentKey.NOW_TIME, System.currentTimeMillis())
                },
                requestCode = 201
            )
        )
    }

    @OnActivityResult(200)
    fun onActivity200(data: Bundle?) {
        _activityResult.value =
            "${200}_${data?.getString(IntentKey.TOKEN)}, ${data?.getLong(IntentKey.NOW_TIME)}"
    }

    @OnActivityResult(201)
    fun onActivity2001(data: Bundle?) {
        _activityResult.value =
            "${201}_${data?.getString(IntentKey.TOKEN)}, ${data?.getLong(IntentKey.NOW_TIME)}"
    }

}
