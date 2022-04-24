package com.hmju.presentation.base

import android.Manifest
import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.hmju.lifecycle.OnPermissionResult
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import java.io.Serializable
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject

/**
 * Description : 액티비티 전용 ViewModel 클래스
 * 액티비티에서만 사용되는 공통 LiveData 들을 정의합니다.
 * Created by juhongmin on 2022/04/13
 */
@HiltViewModel
open class ActivityViewModel @Inject constructor() : BaseViewModel() {

    companion object {
        @Volatile // 무슨일이 있어도 앱 실행중에는 메모리가 삭제되어서는 안된다.
        var cachePermissionMap = ConcurrentHashMap<String, Int>()
    }

    @Inject
    lateinit var savedStateHandle: SavedStateHandle

    protected val _startActivityPage: MutableLiveData<ActivityResult> by lazy { MutableLiveData() }
    val startActivityPage: LiveData<ActivityResult> get() = _startActivityPage

    fun getBundleData(): Bundle {
        val bundle = Bundle()
        savedStateHandle.keys().forEach { key ->
            when (val value = savedStateHandle.get<Any>(key)) {
                is String -> bundle.putString(key, value)
                is Int -> bundle.putInt(key, value)
                is Long -> bundle.putLong(key, value)
                is Double -> bundle.putDouble(key, value)
                is Boolean -> bundle.putBoolean(key, value)
                is Float -> bundle.putFloat(key, value)
                is Array<*>,
                is Parcelable,
                is Serializable -> {
                    putBundle(key, value, bundle)
                }
            }
        }
        return bundle
    }

    /**
     * 특정 Bundle 들을 저장하기 위한 함수
     * @param key Put Key
     * @param value Array, Parcelable, Serializable Type.
     * @param bundle 저장할 Bundle 데이터
     */
    private inline fun <reified T> putBundle(key: String, value: T, bundle: Bundle) {
        try {
            when (value) {
                is Array<*> -> bundle.putStringArray(key, savedStateHandle.get<Array<String>>(key))
                is Parcelable -> bundle.putParcelable(key, savedStateHandle.get(key))
                is Serializable -> bundle.putSerializable(key, savedStateHandle.get(key))
            }
        } catch (ex: Exception) {
            Timber.e("ERROR $ex")
        }
    }

    /**
     * onPermissionResult 에 대한 처리
     * @param resultPermissionMap 전달 받은 권한 리턴 맵
     */
    fun performPermissionResult(resultPermissionMap: Map<String, Boolean>) {
        Flowable.fromIterable(javaClass.methods.toList())
            .filter { it.isAnnotationPresent(OnPermissionResult::class.java) }
            .map { method ->
                val map = ConcurrentHashMap<String, Boolean>()
                method.getAnnotation(OnPermissionResult::class.java)?.let { annotation ->
                    annotation.permissions.forEach { permission ->
                        resultPermissionMap[permission]?.let { isGranted ->
                            map[permission] = isGranted
                        }
                    }
                }
                return@map map to method
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ pair ->
                if (pair.first.size > 0) {
                    pair.second.invoke(this, pair.first)
                }
            }, {
                Timber.d("ERROR $it")
            }).addTo(compositeDisposable)
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
}
