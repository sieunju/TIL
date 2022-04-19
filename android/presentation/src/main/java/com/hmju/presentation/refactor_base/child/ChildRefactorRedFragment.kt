package com.hmju.presentation.refactor_base.child

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.hmju.presentation.BR
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseFragmentV2
import com.hmju.presentation.databinding.FChildRefactorRedBinding
import com.hmju.presentation.refactor_base.RefactorBaseRootTestViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/18
 */
@AndroidEntryPoint
class ChildRefactorRedFragment : BaseFragmentV2<FChildRefactorRedBinding,ChildRefactorRedViewModel>(
    R.layout.f_child_refactor_red
){
    override val viewModel: ChildRefactorRedViewModel by initViewModel()

    private val parentViewModel: RefactorBaseRootTestViewModel by viewModels(
        ownerProducer = { requireParentFragment() }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.parentVm, parentViewModel)
    }
}
