package com.hmju.presentation.mvvm_lifecycle

import android.os.Bundle
import androidx.activity.viewModels
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseActivity
import com.hmju.presentation.databinding.ActivityMvvmLifecycleTest2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MvvmLifecycleTestActivity2 :
    BaseActivity<MvvmLifecycleTestViewModel2, ActivityMvvmLifecycleTest2Binding>(
        R.layout.activity_mvvm_lifecycle_test2
    ) {

    override val viewModel: MvvmLifecycleTestViewModel2 by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}