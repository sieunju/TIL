package com.hmju.presentation.refactor_base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.hmju.lifecycle.OnCreated
import com.hmju.presentation.IntentKey
import com.hmju.presentation.base.ActivityViewModel
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
    private val savedStateHandle: SavedStateHandle
) : ActivityViewModel() {

    private val _title: MutableLiveData<String> by lazy { MutableLiveData() }
    val title: LiveData<String> get() = _title

    @OnCreated
    fun onCreate() {
        _title.value = savedStateHandle.get<String>(IntentKey.TOKEN) ?: run { "Data 가 없습니다.." }
    }

    fun onResult(){
        Timber.d("아직 공사중....")
    }
}
