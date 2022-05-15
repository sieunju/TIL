package com.hmju.presentation.mvvm_lifecycle

import android.content.Intent
import android.os.Bundle
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseActivity
import com.hmju.presentation.databinding.ActivityMvvmLifecycleTestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MvvmLifecycleTestActivity :
    BaseActivity<ActivityMvvmLifecycleTestBinding, MvvmLifecycleTestViewModel>(
        R.layout.activity_mvvm_lifecycle_test
    ) {

    override val viewModel: MvvmLifecycleTestViewModel by initViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(viewModel) {
            startMovePageEvent.observe(this@MvvmLifecycleTestActivity) {
                Intent(
                    this@MvvmLifecycleTestActivity,
                    MvvmLifecycleTest2Activity::class.java
                ).apply {
                    this@MvvmLifecycleTestActivity.startActivity(this)
                }
            }
        }
    }
}
