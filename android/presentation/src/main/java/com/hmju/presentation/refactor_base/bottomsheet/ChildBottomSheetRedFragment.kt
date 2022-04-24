package com.hmju.presentation.refactor_base.bottomsheet

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.hmju.presentation.BR
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseFragment
import com.hmju.presentation.databinding.FChildBottomSheetRedBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/18
 */
@AndroidEntryPoint
class ChildBottomSheetRedFragment
    : BaseFragment<FChildBottomSheetRedBinding, ChildBottomSheetRedViewModel>(
    R.layout.f_child_bottom_sheet_red
) {
    override val viewModel: ChildBottomSheetRedViewModel by initViewModel()

    private val parentViewModel: RefactorBottomSheetViewModel by viewModels({ requireParentFragment() })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.parentVm, parentViewModel)
    }

    companion object {
        fun newInstance(): ChildBottomSheetRedFragment {
            return ChildBottomSheetRedFragment()
        }
    }
}