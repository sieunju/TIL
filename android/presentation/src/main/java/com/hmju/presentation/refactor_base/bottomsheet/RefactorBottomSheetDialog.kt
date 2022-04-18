package com.hmju.presentation.refactor_base.bottomsheet

import com.hmju.presentation.R
import com.hmju.presentation.base.BaseBottomSheetDialog
import com.hmju.presentation.databinding.DRefactorBottomSheetBinding

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/18
 */
class RefactorBottomSheetDialog :
    BaseBottomSheetDialog<DRefactorBottomSheetBinding, RefactorBottomSheetViewModel>(
        R.layout.d_refactor_bottom_sheet
    ) {

    override val viewModel: RefactorBottomSheetViewModel by initViewModel()

}
