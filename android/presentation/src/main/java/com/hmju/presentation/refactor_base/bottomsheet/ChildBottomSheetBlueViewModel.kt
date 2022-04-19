package com.hmju.presentation.refactor_base.bottomsheet

import com.hmju.lifecycle.OnViewCreated
import com.hmju.presentation.base.BottomSheetViewModel
import com.hmju.presentation.base.FragmentViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/18
 */
@HiltViewModel
class ChildBottomSheetBlueViewModel @Inject constructor(

) : FragmentViewModel() {

    @OnViewCreated
    fun getGoodsTest(){

    }
}
