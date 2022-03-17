package com.hmju.presentation.mvvm_lifecycle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.hmju.lifecycle.OnResumed
import com.hmju.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/03/17
 */
@HiltViewModel
class MvvmLifecycleTest3FragmentViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle
) : BaseViewModel() {

    val startFragment: MutableLiveData<Unit> by lazy { MutableLiveData() }
    val startToast : MutableLiveData<String> by lazy { MutableLiveData() }

    @OnResumed
    fun onResume(){
        startToast.value = "테스트 3 완료"
        stateHandle["TEST_KEY"] = "adfasdfasdf"
    }

    fun moveTest4Fragment() {
        startFragment.value = null
    }
}