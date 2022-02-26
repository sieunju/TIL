package com.hmju.presentation.mvvm_lifecycle

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/26
 */
@AndroidEntryPoint
class MvvmLifecycleFragment : BaseFragment<LifecycleViewModel>(R.layout.f_mvvm_lifecycle) {

    override val viewModel: LifecycleViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {

        }
    }
}
