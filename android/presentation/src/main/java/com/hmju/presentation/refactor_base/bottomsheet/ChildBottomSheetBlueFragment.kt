package com.hmju.presentation.refactor_base.bottomsheet

import android.os.Bundle
import android.view.View
import com.hmju.presentation.BR
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseFragmentV2
import com.hmju.presentation.databinding.FChildBottomSheetBlueBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/18
 */
@AndroidEntryPoint
class ChildBottomSheetBlueFragment
    : BaseFragmentV2<FChildBottomSheetBlueBinding, ChildBottomSheetBlueViewModel>(
    R.layout.f_child_bottom_sheet_blue
) {
    override val viewModel: ChildBottomSheetBlueViewModel by initViewModel()

    private lateinit var parentViewModel: RefactorBottomSheetViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentViewModel = parentViewModel(requireParentFragment())
        binding.setVariable(BR.parentVm, parentViewModel)
    }

    companion object {
        fun newInstance(): ChildBottomSheetBlueFragment {
            return ChildBottomSheetBlueFragment()
        }
    }
}
