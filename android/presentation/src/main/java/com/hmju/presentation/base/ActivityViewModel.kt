package com.hmju.presentation.base

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import java.io.Serializable
import javax.inject.Inject

/**
 * Description : 액티비티 전용 ViewModel 클래스
 * 액티비티에서만 사용되는 공통 LiveData 들을 정의합니다.
 * Created by juhongmin on 2022/04/13
 */
@HiltViewModel
open class ActivityViewModel @Inject constructor() : BaseViewModelV2() {

    @Inject
    lateinit var savedStateHandle: SavedStateHandle

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

}
