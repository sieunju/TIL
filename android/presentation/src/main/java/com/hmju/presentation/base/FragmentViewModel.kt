package com.hmju.presentation.base

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Description : Fragment 전용 ViewModel 클래스
 * Fragment 사용되는 공통 LiveData 들을 정의합니다.
 * Created by juhongmin on 2022/04/15
 */
@HiltViewModel
open class FragmentViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var savedStateHandle: SavedStateHandle
}
