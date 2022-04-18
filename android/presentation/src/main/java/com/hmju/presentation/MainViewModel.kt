package com.hmju.presentation

import androidx.lifecycle.SavedStateHandle
import com.hmju.presentation.base.BaseViewModel
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnResumed
import com.hmju.presentation.base.ActivityViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/26
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle
) : ActivityViewModel() {

    @com.hmju.lifecycle.OnCreated
    fun onCreate() {
        Timber.d("Handle ${stateHandle.get<String>("KEY")}")
    }

    @com.hmju.lifecycle.OnResumed
    fun checkResume() {
        Timber.d("함수 실행합니다. Resume")
    }
}
