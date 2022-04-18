package com.hmju.presentation.refactor_base.child

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.hmju.presentation.base.FragmentViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/18
 */
@HiltViewModel
class ChildRefactorBlueViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): FragmentViewModel() {
    val startBottomSheetDialog : MutableLiveData<Unit> by lazy { MutableLiveData() }

    fun onBottomSheetDialog(){
        startBottomSheetDialog.value = null
    }
}
