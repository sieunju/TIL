package com.hmju.presentation.mvvm_lifecycle

import android.Manifest
import androidx.lifecycle.SavedStateHandle
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnPermissionResult
import com.hmju.lifecycle.OnResumed
import com.hmju.lifecycle.OnStopped
import com.hmju.loginmanager.LoginManager
import com.hmju.presentation.IntentKey
import com.hmju.presentation.base.ActivityViewModel
import com.til.rxbus.TestBusEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/27
 */
@HiltViewModel
class MvvmLifecycleTestViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val loginManager: LoginManager
) : ActivityViewModel() {

    @OnCreated
    fun savedHandle() {
        Timber.d("Token ${savedStateHandle.get<String>(IntentKey.TOKEN)}")
        Timber.d("NowTime ${savedStateHandle.get<Long>(IntentKey.NOW_TIME)}")
        Timber.d("Test Long Arr ${savedStateHandle.get<LongArray>(IntentKey.TEST_LONG_ARR)}")
    }

    fun onRandomToken() {
        loginManager.setToken("Token ${System.currentTimeMillis()}")
    }

    fun onClick1() {
        TestBusEvent.publish("테스트 버튼 클릭 ${System.currentTimeMillis()}")
    }

    fun onClick2() {
//        movePage(
//            MovePageEvent(
//                target = MvvmLifecycleTest2Activity::class.java,
//                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//            )
//        )
    }

    fun onClick3() {
        loginManager.setToken("Token ${System.currentTimeMillis()}_${Random.nextBytes(10000)}")
//        movePage(
//            MovePageEvent(
//                target = MvvmLifecycleTest2Activity::class.java,
//                bundle = Bundle().apply {
//                    putString(IntentKey.TOKEN, loginManager.getToken())
//                    putLong(IntentKey.NOW_TIME, System.currentTimeMillis())
//                },
//                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_REORDER_TO_FRONT,
//                requestCode = RequestCode.MVVM_LIFECYCLE_2
//            )
//        )
    }

    fun movePage2Req222() {
//        movePage(
//            MovePageEvent(
//                MvvmLifecycleTest2Activity::class.java,
//                bundle = Bundle().apply {
//                    putString(IntentKey.TOKEN, loginManager.getToken())
//                    putLong(IntentKey.NOW_TIME, System.currentTimeMillis())
//                    putLongArray(IntentKey.TEST_LONG_ARR, longArrayOf(33333, 222, 111, 444, 55))
//                },
//                requestCode = RequestCode.MVVM_LIFECYCLE_2
//            )
//        )
    }

    fun movePermission() {
//        movePermissions(
//            listOf(
//                Manifest.permission.ACCESS_FINE_LOCATION,
//                Manifest.permission.CAMERA,
//                Manifest.permission.READ_EXTERNAL_STORAGE
//            )
//        )
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
    fun testOnStopped() {
        Timber.d("stopped ")
    }

    @OnPermissionResult([Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA])
    fun onPermissionResult1(map: Map<String, Boolean>) {
        Timber.d("Permission1 Map $map")
    }

    @OnPermissionResult([Manifest.permission.CAMERA])
    fun onPermissionResult2(map: Map<String, Boolean>) {
        Timber.d("Permission2 Map $map")
    }

    @OnPermissionResult([Manifest.permission.READ_EXTERNAL_STORAGE])
    fun onStorageResult(map: Map<String, Boolean>) {
        Timber.d("Permission3 Map $map")
    }
}
