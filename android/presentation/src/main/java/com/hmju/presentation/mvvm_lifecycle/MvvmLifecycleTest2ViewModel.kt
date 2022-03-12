package com.hmju.presentation.mvvm_lifecycle

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.hmju.lifecycle.MovePage
import com.hmju.lifecycle.OnActivityResult
import com.hmju.lifecycle.OnCreated
import com.hmju.loginmanager.LoginManager
import com.hmju.presentation.IntentKey
import com.hmju.presentation.RequestCode
import com.hmju.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/03/11
 */
@HiltViewModel
class MvvmLifecycleTest2ViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val loginManager: LoginManager
) : BaseViewModel() {

    @OnCreated
    fun onCreate() {
        Timber.d("Token ${savedStateHandle.get<String>(IntentKey.TOKEN)}")
        Timber.d("NowTime ${savedStateHandle.get<Long>(IntentKey.NOW_TIME)}")
        Timber.d("Test Long Arr ${savedStateHandle.get<LongArray>(IntentKey.TEST_LONG_ARR)}")
    }

    fun moveTest3() {
        startActivity.value = MovePage(MvvmLifecycleTest3Activity::class.java)
    }

    fun moveTest3Req111() {
        startActivityResult.value = MovePage(
            MvvmLifecycleTest3Activity::class.java,
            bundle = Bundle().apply {
                putString(IntentKey.TOKEN, loginManager.getToken())
                putLong(IntentKey.NOW_TIME, System.currentTimeMillis())
            },
            requestCode = RequestCode.MVVM_LIFECYCLE_3
        )
    }

    @OnActivityResult(RequestCode.MVVM_LIFECYCLE_3)
    fun onActivityResult(data : Bundle?) {
        data?.let {
            Timber.d("Result Token ${it.getString(IntentKey.TOKEN)}")
            Timber.d("Result Time ${it.getLong(IntentKey.NOW_TIME)}")
        }
    }
}
