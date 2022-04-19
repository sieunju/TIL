package com.hmju.presentation.refactor_base

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hmju.lifecycle.OnActivityResult
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnIntent
import com.hmju.presentation.IntentKey
import com.hmju.presentation.base.ActivityResult
import com.hmju.presentation.base.ActivityViewModel
import com.hmju.presentation.base.RxBusActivityResultEvent
import com.hmju.presentation.mvvm_lifecycle.MvvmLifecycleTestActivity
import com.til.model.test.SerializableEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/03/19
 */
@HiltViewModel
class RefactorTestViewModel @Inject constructor(
) : ActivityViewModel() {

    private val _title: MutableLiveData<String> by lazy { MutableLiveData() }
    val title: LiveData<String> get() = _title
    private val _contents: MutableLiveData<String> by lazy { MutableLiveData() }
    val contents: LiveData<String> get() = _contents

    @OnIntent
    fun intentData() {
        Timber.d("[s] onCreate Intent Data ===============================================")
        savedStateHandle.keys().forEach {
            Timber.d("Key $it Value ${savedStateHandle.get<Any>(it)}")
        }
        Timber.d("[s] onCreate Intent Data ===============================================")
    }

    @OnCreated
    fun onCreate() {
        _title.value = savedStateHandle.get<String>(IntentKey.TOKEN) ?: run { "Data 가 없습니다.." }
    }

    fun onResult() {
        RxBusActivityResultEvent.publish(
            ActivityResult(
                3000,
                MvvmLifecycleTestActivity::class,
                data = Bundle().apply {
//                    putString(IntentKey.TOKEN, "RefactorTestViewModel Random Token")
                    putSerializable(
                        "Serializable",
                        SerializableEntity("testTitle", System.currentTimeMillis())
                    )
                }
            ))
    }

    @OnActivityResult(3000)
    fun onActivityResult(data: Bundle?) {
        if (data == null) return

        Timber.d("[s] Result Data ==================================================")
        val builder = StringBuilder()
        data.keySet().forEach { key ->
            Timber.d("Key $key Value ${data.get(key)}")
            builder.append("Key $key Value ${data.get(key)}\n")
        }
        _contents.value = builder.toString()
        Timber.d("[e] Result Data ==================================================")
    }
}
