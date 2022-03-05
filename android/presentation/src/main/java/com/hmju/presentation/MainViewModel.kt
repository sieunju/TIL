package com.hmju.presentation

import androidx.lifecycle.SavedStateHandle
import com.hmju.presentation.base.BaseViewModel
import com.hmju.presentation.lifecycle.Resume
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
    private val stateHandle : SavedStateHandle
) : BaseViewModel() {

    override fun onCreate() {
        super.onCreate()
        Timber.d("Handle ${stateHandle.get<String>("KEY")}")
    }

    @Resume
    fun checkResume(){

    }
}