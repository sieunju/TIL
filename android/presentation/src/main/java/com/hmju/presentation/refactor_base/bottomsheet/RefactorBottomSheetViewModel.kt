package com.hmju.presentation.refactor_base.bottomsheet

import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnStopped
import com.hmju.lifecycle.OnViewCreated
import com.hmju.presentation.base.BottomSheetViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/18
 */
@HiltViewModel
class RefactorBottomSheetViewModel @Inject constructor(
) : BottomSheetViewModel() {


    @OnCreated
    fun onCreated() {
        Timber.d("onCreated")
    }

    @OnViewCreated
    fun onViewCreated() {
        Timber.d("onViewCreated")
    }

    @OnStopped
    fun onStop(){
        Timber.d("onStop")
    }
}
