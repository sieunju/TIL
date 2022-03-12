package com.hmju.presentation.mvvm_lifecycle

import androidx.activity.viewModels
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseActivity
import com.hmju.presentation.databinding.ActivityMvvmLifecycleTestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MvvmLifecycleTestActivity :
    BaseActivity<ActivityMvvmLifecycleTestBinding, MvvmLifecycleTestViewModel>(
        R.layout.activity_mvvm_lifecycle_test
    ) {

    override val viewModel: MvvmLifecycleTestViewModel by viewModels()
}
