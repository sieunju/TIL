package com.hmju.presentation.refactor_base.bottomsheet

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.hmju.presentation.BR
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseFragmentV2
import com.hmju.presentation.databinding.FChildBottomSheetRedBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/18
 */
@AndroidEntryPoint
class ChildBottomSheetRedFragment
    : BaseFragmentV2<FChildBottomSheetRedBinding, ChildBottomSheetRedViewModel>(
    R.layout.f_child_bottom_sheet_red
) {
    override val viewModel: ChildBottomSheetRedViewModel by initViewModel()

    private lateinit var parentViewModel: RefactorBottomSheetViewModel

    private val testViewModel: RefactorBottomSheetViewModel by viewModels({ requireParentFragment() })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentViewModel = ViewModelProvider(requireParentFragment()).get(RefactorBottomSheetViewModel::class.java)
        Timber.d("LOGGER RedFragment ${requireParentFragment().javaClass.simpleName} $parentViewModel  $testViewModel")
        binding.setVariable(BR.parentVm, parentViewModel)
    }

    companion object {
        fun newInstance(): ChildBottomSheetRedFragment {
            return ChildBottomSheetRedFragment()
        }
    }
}