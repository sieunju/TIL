package com.hmju.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Description : BottomSheet 전용 ViewModel
 *
 * Created by juhongmin on 2022/04/15
 */
open class BottomSheetViewModel : BaseViewModel() {

    protected val _startActivityPage: MutableLiveData<ActivityResult> by lazy { MutableLiveData() }
    val startActivityPage: LiveData<ActivityResult> get() = _startActivityPage
}
