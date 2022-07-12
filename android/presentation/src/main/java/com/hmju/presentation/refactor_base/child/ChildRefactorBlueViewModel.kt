package com.hmju.presentation.refactor_base.child

import androidx.lifecycle.MutableLiveData
import com.hmju.lifecycle.OnCreated
import com.hmju.core.FragmentViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/18
 */
@HiltViewModel
class ChildRefactorBlueViewModel @Inject constructor(
) : FragmentViewModel() {
    val startBottomSheetDialog: MutableLiveData<Unit> by lazy { MutableLiveData() }
    val startParentBottomSheetDialog: MutableLiveData<Unit> by lazy { MutableLiveData() }

    fun onBottomSheetDialog() {
        startBottomSheetDialog.value = null
    }

    fun onParentBottomSheetDialog() {
        startParentBottomSheetDialog.value = null
    }

    @OnCreated
    fun onCreated(){
        savedStateHandle.keys().forEach {
            Timber.d("Key $it Value ${savedStateHandle.get<Any>(it)}")
        }
    }
}
