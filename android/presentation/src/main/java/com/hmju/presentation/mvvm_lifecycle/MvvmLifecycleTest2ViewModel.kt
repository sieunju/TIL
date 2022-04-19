package com.hmju.presentation.mvvm_lifecycle

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.hmju.domain.usecase.GetGoodsUseCase
import com.hmju.lifecycle.OnActivityResult
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnResumed
import com.hmju.loginmanager.LoginManager
import com.hmju.presentation.IntentKey
import com.hmju.presentation.base.ActivityViewModel
import com.til.model.params.GoodsParamMap
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random

/**
 * Description :
 *
 * Created by juhongmin on 2022/03/11
 */
@HiltViewModel
class MvvmLifecycleTest2ViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getGoodsUseCase: GetGoodsUseCase,
    private val loginManager: LoginManager
) : ActivityViewModel() {

    @OnCreated
    fun onCreate() {
        Timber.d("Token ${savedStateHandle.get<String>(IntentKey.TOKEN)}")
        Timber.d("NowTime ${savedStateHandle.get<Long>(IntentKey.NOW_TIME)}")
        Timber.d("Test Long Arr ${savedStateHandle.get<LongArray>(IntentKey.TEST_LONG_ARR)}")
    }

    @OnResumed
    fun onResume() {
//        activityStack.value = getActivityStackStr()
//        fragmentStack.value = getFragmentStackStr()
    }

    fun changeToken() {
        getGoodsUseCase(GoodsParamMap())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loginManager.setToken(it[Random.nextInt(10)].message)
            }, {

            })
    }

    fun moveTest3Page() {
//        movePage(
//            MovePageEvent(
//                MvvmLifecycleTest3Activity::class.java,
//                requestCode = 2000,
//                bundle = Bundle().apply {
//                    putLong(IntentKey.NOW_TIME,Random.nextLong())
//                    putString("TEST_KEY","aa")
//                }
//            )
//        )
    }

    @OnActivityResult(2000)
    fun on2000Result(data: Bundle?) {
        Timber.d("[s] Result Data 2000 ==================================================")
        data?.let {
            it.keySet().forEach { str ->
                Timber.d("Key $str Value ${it.get(str)}")
            }
        }
        Timber.d("[e] Result Data 2000 ==================================================")
    }
}
