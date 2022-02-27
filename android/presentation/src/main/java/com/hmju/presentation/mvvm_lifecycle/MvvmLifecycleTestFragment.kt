package com.hmju.presentation.mvvm_lifecycle

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseFragment
import com.hmju.presentation.databinding.FMvvmLifecycleTestBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/27
 */
@AndroidEntryPoint
class MvvmLifecycleTestFragment :
    BaseFragment<MvvmLifecycleTestViewModel, FMvvmLifecycleTestBinding>(
        R.layout.f_mvvm_lifecycle_test
    ) {

    override val viewModel: MvvmLifecycleTestViewModel by viewModels()
    override val binding: FMvvmLifecycleTestBinding by viewBinding()

}