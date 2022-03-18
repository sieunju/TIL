package com.hmju.presentation.base

import android.Manifest
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.hmju.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject

/**
 * Description : BaseViewModel
 *
 * Created by juhongmin on 2022/02/26
 */
open class BaseViewModel : ViewModel() {

    companion object {
        const val REQ_CODE = "req_code"

        @Volatile // 무슨일이 있어도 앱 실행중에는 메모리가 삭제되어서는 안된다.
        var cachePermissionMap = ConcurrentHashMap<String, Int>()
    }

    protected val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    protected val _resultIntentData: MutableLiveData<Bundle> by lazy { MutableLiveData() }
    val resultIntentData: LiveData<Bundle> get() = _resultIntentData
    val startActivity: MutableLiveData<MovePageEvent> by lazy { MutableLiveData() }
    val startActivityResult: MutableLiveData<MovePageEvent> by lazy { MutableLiveData() }
    val startPermission: MutableLiveData<List<String>> by lazy { MutableLiveData() }

    val activityStack: MutableLiveData<String> by lazy { MutableLiveData() }
    val fragmentStack: MutableLiveData<String> by lazy { MutableLiveData() }

    fun getActivityStackStr(): String {
        return BaseActivity.activityStackList.joinToString("\n>")
    }

    fun getFragmentStackStr(): String {
        return BaseFragment.fragmentStackList.joinToString("\n>")
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
     * [OnCreated], [OnResumed], [OnStopped], [OnViewCreated]
     * ReactiveX 타입
     * 선언된 함수를 실행 하는 함수
     */
    inline fun <reified T : Annotation> performLifecycleRx(): Disposable {
        return Flowable.fromIterable(javaClass.methods.toList())
            .filter { it.isAnnotationPresent(T::class.java) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.invoke(this)
            }, {
                Timber.e("PerformLifecycleRx Error $it")
            })
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
                    if (annotation.requestCode == code) {
                        runCatching {
                            method.invoke(this, data)
                        }
                    }
                }
            }
        }
    }

    /**
     * onActivityResult 에 대한 처리
     * ReactiveX 타입
     * @param code RequestCode
     * @param data 전달 받을 데이터
     */
    fun performActivityResultRx(code: Int, data: Bundle?) {
        Flowable.fromIterable(javaClass.methods.toList())
            .filter { it.isAnnotationPresent(OnActivityResult::class.java) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ method ->
                method.getAnnotation(OnActivityResult::class.java)?.let { annotation ->
                    // RequestCode 와 같은 함수만 호출
                    if (annotation.requestCode == code) {
                        method.invoke(this, data)
                    }
                }
            }, {
                Timber.e("performActivityResultRx Error $it")
            }).addTo(compositeDisposable)
    }

    /**
     * onPermissionResult 에 대한 처리
     * @param resultPermissionMap 전달 받은 권한 리턴 맵
     */
    fun performPermissionResult(resultPermissionMap: Map<String, Boolean>) {
        javaClass.methods.forEach { method ->
            if (method.isAnnotationPresent(OnPermissionResult::class.java)) {
                method.getAnnotation(OnPermissionResult::class.java)?.let { annotation ->
                    val map = ConcurrentHashMap<String, Boolean>()
                    annotation.permissions.forEach { permission ->
                        resultPermissionMap[permission]?.let { isGranted ->
                            map[permission] = isGranted
                        }
                    }
                    if (map.size > 0) {
                        runCatching {
                            method.invoke(this, map)
                        }
                    }
                }
            }
        }
    }

    /**
     * onPermissionResult 에 대한 처리
     * ReactiveX 타입
     * @param resultPermissionMap 전달 받은 권한 리턴 맵
     */
    fun performPermissionResultRx(resultPermissionMap: Map<String, Boolean>) {
        Flowable.fromIterable(javaClass.methods.toList())
            .filter { it.isAnnotationPresent(OnPermissionResult::class.java) }
            .map { method ->
                return@map method.getAnnotation(OnPermissionResult::class.java)?.let {
                    method to it
                } ?: run {
                    throw NullPointerException("Annotation is Null")
                }
            }
            .map { pair ->
                val map = ConcurrentHashMap<String, Boolean>()
                pair.second.permissions.forEach { permission ->
                    resultPermissionMap[permission]?.let { isGranted ->
                        map[permission] = isGranted
                    }
                }
                if (map.size > 0) {
                    return@map pair.first to map
                } else {
                    throw NullPointerException("Map is Null")
                }
            }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ pair ->
                pair.first.invoke(this, pair.second)
            }, {

            })

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
    protected fun movePermissions(list: List<String>) {
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

        // Timber.d("Permission Map $cachePermissionMap")

        list.forEach { str ->
            if (cachePermissionMap.containsKey(str)) {
                permissionList.add(str)
            }
        }
        return permissionList
    }

    /**
     * setResult 할때 데이터 전달하기위한 함수
     * @param bundle BundleData
     */
    protected fun saveResultData(bundle: Bundle?) {
        if (bundle != null) {
            _resultIntentData.value = bundle
        }
    }

    /**
     * CompositeDisposable 를 public 으로 처리할수 있는 함수
     * @param disposable Disposable
     */
    fun addDisposable(disposable: Disposable) {
        disposable.addTo(compositeDisposable)
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
