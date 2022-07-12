package com.hmju.presentation.refactor_diff_util_v2

import android.os.Bundle
import android.view.View
import com.hmju.presentation.R
import com.hmju.core.BaseFragment
import com.hmju.presentation.BR
import com.hmju.presentation.databinding.FDiffUtil2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiffUtil2Fragment :
    BaseFragment<FDiffUtil2Binding, DiffUtil2ViewModel>(R.layout.f_diff_util2) {

    override val viewModel: DiffUtil2ViewModel by initViewModel()
    override val bindingVariable: Int = BR.vm

    private val adapter : DiffUtil2ListAdapter by lazy { DiffUtil2ListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvContents.adapter = adapter
        with(viewModel) {
            dataList.observe(viewLifecycleOwner) {
                adapter.submitList(it)
            }
        }
    }
}
