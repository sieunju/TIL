package com.hmju.presentation.mvvm_lifecycle

import androidx.lifecycle.SavedStateHandle
import com.hmju.domain.usecase.GetGoodsUseCase
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnResumed
import com.hmju.lifecycle.OnStopped
import com.hmju.loginmanager.LoginManager
import com.hmju.core.ActivityViewModel
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
    private val handle: SavedStateHandle,
    private val getGoodsUseCase: GetGoodsUseCase,
    private val loginManager: LoginManager
) : ActivityViewModel() {

    @OnCreated
    fun savedHandle() {
        handle.keys().forEach {
            Timber.d("Key $it ${handle.get<Any>(it)}")
        }
        handle["TEST_KEY"] = "TETKKEKEKQKEKQKEKEKEKEKEKE"
//        activityStack.value = getActivityStackStr()
//        fragmentStack.value = getFragmentStackStr()
    }

    @OnResumed
    fun onResume() {
//        activityStack.value = getActivityStackStr()
//        fragmentStack.value = getFragmentStackStr()
    }

    @OnStopped
    fun onStop() {
//        saveResultData(Bundle().apply {
//            putString("TEST_KEY", "AAEFEFEFEFEFEFEFEFEFA")
//        })
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
//        movePage(MovePageEvent(
//            MvvmLifecycleTest2Activity::class.java,
//            bundle = Bundle().apply {
//                putLong(IntentKey.NOW_TIME, System.currentTimeMillis())
//            }
//        ))
    }
}