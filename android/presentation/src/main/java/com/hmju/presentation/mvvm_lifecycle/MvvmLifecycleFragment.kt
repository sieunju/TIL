package com.hmju.presentation.mvvm_lifecycle

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseFragment
import com.hmju.presentation.databinding.FMvvmLifecycleBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/26
 */
@AndroidEntryPoint
class MvvmLifecycleFragment : BaseFragment<LifecycleViewModel, FMvvmLifecycleBinding>(
    R.layout.f_mvvm_lifecycle
) {

    override val viewModel: LifecycleViewModel by viewModels()
    override val binding: FMvvmLifecycleBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {

        }
    }
}
