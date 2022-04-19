package com.hmju.presentation.mvvm_lifecycle

import com.hmju.presentation.R
import com.hmju.presentation.base.BaseActivityV2
import com.hmju.presentation.databinding.ActivityMvvmLifecycleTestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MvvmLifecycleTestActivity
    : BaseActivityV2<ActivityMvvmLifecycleTestBinding, MvvmLifecycleTestViewModel>(
    R.layout.activity_mvvm_lifecycle_test
) {

    override val viewModel: MvvmLifecycleTestViewModel by initViewModel()
}
