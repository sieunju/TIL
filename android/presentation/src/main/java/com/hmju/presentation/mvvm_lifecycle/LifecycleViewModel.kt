package com.hmju.presentation.mvvm_lifecycle

import com.hmju.presentation.base.BaseViewModel
import com.hmju.presentation.lifecycle.onInit
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/26
 */
@HiltViewModel
class LifecycleViewModel @Inject constructor() : BaseViewModel() {

    override fun onCreate() {
        super.onCreate()
    }
}
