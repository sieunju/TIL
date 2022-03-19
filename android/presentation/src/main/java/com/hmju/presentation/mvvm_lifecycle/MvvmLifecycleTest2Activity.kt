package com.hmju.presentation.mvvm_lifecycle

import androidx.activity.viewModels
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseActivity
import com.hmju.presentation.databinding.ActivityMvvmLifecycleTest2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MvvmLifecycleTest2Activity :
    BaseActivity<ActivityMvvmLifecycleTest2Binding, MvvmLifecycleTest2ViewModel>(
        R.layout.activity_mvvm_lifecycle_test2
    ) {

    override val viewModel: MvvmLifecycleTest2ViewModel by viewModels()
}
