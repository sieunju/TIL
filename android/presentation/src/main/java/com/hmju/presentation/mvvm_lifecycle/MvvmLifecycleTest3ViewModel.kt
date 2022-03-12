package com.hmju.presentation.mvvm_lifecycle

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.hmju.domain.usecase.GetGoodsUseCase
import com.hmju.lifecycle.MovePageEvent
import com.hmju.lifecycle.OnCreated
import com.hmju.loginmanager.LoginManager
import com.hmju.presentation.IntentKey
import com.hmju.presentation.base.BaseViewModel
import com.til.model.params.GoodsParamMap
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/03/12
 */
@HiltViewModel
class MvvmLifecycleTest3ViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getGoodsUseCase: GetGoodsUseCase,
    private val loginManager: LoginManager
) : BaseViewModel() {

    @OnCreated
    fun savedHandle() {
        Timber.d("Token ${savedStateHandle.get<String>(IntentKey.TOKEN)}")
        Timber.d("NowTime ${savedStateHandle.get<Long>(IntentKey.NOW_TIME)}")
        Timber.d("Test Long Arr ${savedStateHandle.get<LongArray>(IntentKey.TEST_LONG_ARR)}")
    }

    @OnCreated
    fun start() {
        val queryMap = GoodsParamMap()
        getGoodsUseCase(queryMap)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loginManager.setToken(it[0].imagePath)
                Timber.d("SUCC $it")
            }, {
                Timber.e("Error $it")
            })
    }

    fun moveTest2Page() {
        movePage(MovePageEvent(
            MvvmLifecycleTest2Activity::class.java,
            bundle = Bundle().apply {
                putLong(IntentKey.NOW_TIME, System.currentTimeMillis())
            }
        ))
    }
}