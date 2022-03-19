package com.hmju.presentation.mvvm_lifecycle

import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import androidx.fragment.app.commitNow
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseFragment
import com.hmju.presentation.databinding.FMvvmLifecycle3Binding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description :
 *
 * Created by juhongmin on 2022/03/17
 */
@AndroidEntryPoint
class MvvmLifecycleTest3Fragment : BaseFragment<FMvvmLifecycle3Binding,MvvmLifecycleTest3FragmentViewModel>(
    R.layout.f_mvvm_lifecycle_3) {
    override val viewModel: MvvmLifecycleTest3FragmentViewModel by viewModels()
    override val binding: FMvvmLifecycle3Binding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            startFragment.observe(viewLifecycleOwner) {
                parentFragmentManager.beginTransaction().apply {
                    add(R.id.container,MvvmLifecycleTest4Fragment())
                    addToBackStack("")
                    commit()
                }
            }
            startToast.observe(viewLifecycleOwner) {
                Snackbar.make(binding.root,it, Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}