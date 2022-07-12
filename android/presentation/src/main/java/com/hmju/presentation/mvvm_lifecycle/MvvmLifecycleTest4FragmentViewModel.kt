package com.hmju.presentation.mvvm_lifecycle

import androidx.lifecycle.MutableLiveData
import com.hmju.lifecycle.OnResumed
import com.hmju.core.FragmentViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/03/17
 */
@HiltViewModel
class MvvmLifecycleTest4FragmentViewModel @Inject constructor() : FragmentViewModel() {

    val startFragment: MutableLiveData<Unit> by lazy { MutableLiveData() }
    val startToast: MutableLiveData<String> by lazy { MutableLiveData() }

    @OnResumed
    fun onResume() {
        startToast.value = "테스트 4 완료"
    }

    fun moveTest3Fragment() {
        startFragment.value = null
    }
}
