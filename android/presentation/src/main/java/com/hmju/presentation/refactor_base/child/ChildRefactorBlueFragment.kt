package com.hmju.presentation.refactor_base.child

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.hmju.presentation.BR
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseFragmentV2
import com.hmju.presentation.databinding.FChildRefactorBlueBinding
import com.hmju.presentation.refactor_base.RefactorBaseRootTestViewModel
import com.hmju.presentation.refactor_base.bottomsheet.RefactorBottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/18
 */
@AndroidEntryPoint
class ChildRefactorBlueFragment
    : BaseFragmentV2<FChildRefactorBlueBinding, ChildRefactorBlueViewModel>(
    R.layout.f_child_refactor_blue
) {
    override val viewModel: ChildRefactorBlueViewModel by initViewModel()
    private val parentViewModel: RefactorBaseRootTestViewModel by viewModels(
        ownerProducer = { requireParentFragment() }
    )

    private val bottomSheetDialog: RefactorBottomSheetDialog by lazy { RefactorBottomSheetDialog() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.parentViewModel, parentViewModel)

        with(viewModel) {
            startBottomSheetDialog.observe(viewLifecycleOwner) {
                bottomSheetDialog.show(childFragmentManager, "RefactorBottomSheetDialog")
            }
        }
    }
}