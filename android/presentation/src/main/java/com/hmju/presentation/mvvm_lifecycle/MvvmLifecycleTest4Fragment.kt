package com.hmju.presentation.mvvm_lifecycle

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseFragmentV2
import com.hmju.presentation.databinding.FMvvmLifecycle4Binding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description :
 *
 * Created by juhongmin on 2022/03/17
 */
@AndroidEntryPoint
class MvvmLifecycleTest4Fragment :
    BaseFragmentV2<FMvvmLifecycle4Binding, MvvmLifecycleTest4FragmentViewModel>(
        R.layout.f_mvvm_lifecycle_4
    ) {
    override val viewModel: MvvmLifecycleTest4FragmentViewModel by initViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            startFragment.observe(viewLifecycleOwner) {
                parentFragmentManager.beginTransaction().apply {
                    add(R.id.container, MvvmLifecycleTest3Fragment())
                    addToBackStack(null)
                    commit()
                }
            }
            startToast.observe(viewLifecycleOwner) {
                Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}