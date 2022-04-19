package com.hmju.presentation.mvvm_lifecycle

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.hmju.lifecycle.*
import com.hmju.loginmanager.LoginManager
import com.hmju.presentation.IntentKey
import com.hmju.presentation.base.ActivityResult
import com.hmju.presentation.base.ActivityViewModel
import com.hmju.presentation.base.RxBusActivityResultEvent
import com.hmju.presentation.refactor_base.RefactorBaseTestActivity
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
    private val loginManager: LoginManager
) : ActivityViewModel() {

    private val _contents : MutableLiveData<String> by lazy { MutableLiveData() }
    val contents : LiveData<String> get() = _contents

    @OnIntent
    fun intentData() {
        Timber.d("[s] onCreate Intent Data ===============================================")
        val builder = StringBuilder()
        savedStateHandle.keys().forEach {
            Timber.d("Key $it Value ${savedStateHandle.get<Any>(it)}")
            builder.append("Key $it Value ${savedStateHandle.get<Any>(it)}\n")
        }
        _contents.value = builder.toString()
        Timber.d("[s] onCreate Intent Data ===============================================")
    }

    fun onRandomToken() {
        loginManager.setToken("Token ${System.currentTimeMillis()}")
        savedStateHandle.set("HiKey","dddfefefeffe")
        savedStateHandle.set("Hello....",System.currentTimeMillis())
        savedStateHandle.set(IntentKey.TOKEN,"ChangeResult")
    }

    fun onClick1() {
        TestBusEvent.publish("테스트 버튼 클릭 ${System.currentTimeMillis()}")
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
        loginManager.setToken("Token ${System.currentTimeMillis()}_${Random.nextBytes(10000)}")
        RxBusActivityResultEvent.publish(
            ActivityResult(
                3001,
                RefactorBaseTestActivity::class,
                flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT,
                data = Bundle().apply {
                    putString(IntentKey.TOKEN, loginManager.getToken())
                }
            ))
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

    @OnActivityResult(3001)
    fun onActivityResult(data: Bundle?) {
        Timber.d("[s] Result Data ==================================================")
        data?.let {
            it.keySet().forEach { str ->
                Timber.d("Key $str Value ${it.get(str)}")
            }
        }
        Timber.d("[e] Result Data ==================================================")
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
