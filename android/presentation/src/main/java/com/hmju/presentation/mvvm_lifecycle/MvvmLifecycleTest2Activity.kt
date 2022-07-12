package com.hmju.presentation.mvvm_lifecycle

import android.content.Intent
import android.os.Bundle
import com.hmju.presentation.R
import com.hmju.core.BaseActivity
import com.hmju.presentation.BR
import com.hmju.presentation.databinding.ActivityMvvmLifecycleTest2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MvvmLifecycleTest2Activity
    : BaseActivity<ActivityMvvmLifecycleTest2Binding, MvvmLifecycleTest2ViewModel>(
    R.layout.activity_mvvm_lifecycle_test2
) {

    override val viewModel: MvvmLifecycleTest2ViewModel by initViewModel()
    override val bindingVariable: Int = BR.vm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(viewModel){
            startMovePageEvent.observe(this@MvvmLifecycleTest2Activity) {
                Intent(
                    this@MvvmLifecycleTest2Activity,
                    MvvmLifecycleTest3Activity::class.java
                ).apply {
                    this@MvvmLifecycleTest2Activity.startActivity(this)
                }
            }
        }
    }
}
