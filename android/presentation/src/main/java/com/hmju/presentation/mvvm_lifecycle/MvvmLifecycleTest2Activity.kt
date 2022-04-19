package com.hmju.presentation.mvvm_lifecycle

import com.hmju.presentation.R
import com.hmju.presentation.base.BaseActivityV2
import com.hmju.presentation.databinding.ActivityMvvmLifecycleTest2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MvvmLifecycleTest2Activity
    : BaseActivityV2<ActivityMvvmLifecycleTest2Binding, MvvmLifecycleTest2ViewModel>(
    R.layout.activity_mvvm_lifecycle_test2
) {

    override val viewModel: MvvmLifecycleTest2ViewModel by initViewModel()
}
