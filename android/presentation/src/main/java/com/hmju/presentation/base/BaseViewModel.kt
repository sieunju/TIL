package com.hmju.presentation.base

import android.Manifest
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hmju.lifecycle.*
import com.hmju.presentation.lifecycle.LifecycleController
import com.hmju.presentation.lifecycle.LifecycleObserver
import com.hmju.presentation.lifecycle.RxLifecycleDelegate
import io.reactivex.rxjava3.disposables.CompositeDisposable
import timber.log.Timber
import java.util.concurrent.ConcurrentHashMap

/**
 * Description : BaseViewModel
 *
 * Created by juhongmin on 2022/02/26
 */
open class BaseViewModel : ViewModel(), RxLifecycleDelegate {

    companion object {
        const val REQ_CODE = "req_code"

        @Volatile // 무슨일이 있어도 앱 실행중에는 메모리가 삭제되어서는 안된다.
        var cachePermissionMap = ConcurrentHashMap<String, Int>()
    }

    protected val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }
    val lifecycleController: LifecycleController by lazy { LifecycleController() }

    val startActivity: MutableLiveData<MovePageEvent> by lazy { MutableLiveData() }
    val startActivityResult: MutableLiveData<MovePageEvent> by lazy { MutableLiveData() }
    val startPermission: MutableLiveData<List<String>> by lazy { MutableLiveData() }

    @Deprecated(
        message = "ViewModel 에서 Annotation 으로 처리하는것으로 변경했습니다.",
        replaceWith = ReplaceWith("OnCreated, OnResumed, OnStopped")
    )
    override fun LifecycleObserver.unaryPlus() {
        lifecycleController += this
    }

    /**
     * [OnCreated], [OnResumed], [OnStopped], [OnViewCreated]
     * 선언된 함수를 실행 하는 함수
     */
    inline fun <reified T : Annotation> performLifecycle() {
        javaClass.methods.forEach { method ->
            if (method.isAnnotationPresent(T::class.java)) {
                runCatching {
                    method.invoke(this)
                }
            }
        }
    }

    /**
     * onActivityResult 에 대한 처리
     * @param code RequestCode
     * @param data 전달 받을 데이터
     */
    fun performActivityResult(code: Int, data: Bundle?) {
        javaClass.methods.forEach { method ->
            if (method.isAnnotationPresent(OnActivityResult::class.java)) {
                method.getAnnotation(OnActivityResult::class.java)?.let { annotation ->
                    if (annotation.code == code) {
                        runCatching {
                            method.invoke(this, data)
                        }
                    }
                }
            }
        }
    }

    /**
     * 간단하게 페이지 이동 처리
     * @param movePageEvent MovePage Data Model
     */
    protected fun movePage(movePageEvent: MovePageEvent) {
        if (movePageEvent.requestCode != null) {
            startActivityResult.value = movePageEvent
        } else {
            startActivity.value = movePageEvent
        }
    }

    /**
     * 권한 요청 처리 함수
     * @param list 검증되지 않은 권한들
     */
    protected fun movePermissions(list : List<String>) {
        startPermission.value = validatePermission(list)
    }

    /**
     * 데이터 리스트 안에 유효하지 않는 권한에 대해서 필터링 처리 해주는 함수
     * @param list 검증되지 않은 권한 값
     */
    private fun validatePermission(list: List<String>): List<String> {
        val permissionList = mutableListOf<String>()
        // 권한을 가지고 있는 필드 값들은 앱실행후 한번만 요청하고 처리하도록
        if (cachePermissionMap.size == 0) {
            val permissionClass = Manifest.permission::class.java.newInstance()
            val groupClass = Manifest.permission_group::class.java.newInstance()

            Manifest.permission::class.java.fields.forEach {
                if (!it.isAnnotationPresent(Deprecated::class.java) && it.get(permissionClass) is String) {
                    cachePermissionMap[it.get(permissionClass) as String] = 0
                }
            }

            Manifest.permission_group::class.java.fields.forEach {
                if (!it.isAnnotationPresent(Deprecated::class.java) && it.get(groupClass) is String) {
                    cachePermissionMap[it.get(groupClass) as String] = 0
                }
            }
        }

        Timber.d("Permission Map $cachePermissionMap")

        list.forEach { str ->
            if (cachePermissionMap.containsKey(str)) {
                permissionList.add(str)
            }
        }
        return permissionList
    }

    fun clearDisposable() {
        compositeDisposable.clear()
    }

    override fun onCleared() {
        super.onCleared()
        if (compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}
