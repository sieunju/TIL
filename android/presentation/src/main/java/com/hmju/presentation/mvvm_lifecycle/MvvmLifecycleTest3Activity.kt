package com.hmju.presentation.mvvm_lifecycle

import android.os.Bundle
import androidx.activity.viewModels
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseActivityV2
import com.hmju.presentation.databinding.ActivityMvvmLifecycleTest3Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MvvmLifecycleTest3Activity
    : BaseActivityV2<ActivityMvvmLifecycleTest3Binding, MvvmLifecycleTest3ViewModel>(
    R.layout.activity_mvvm_lifecycle_test3
) {

    override val viewModel: MvvmLifecycleTest3ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, MvvmLifecycleTest3Fragment())
            addToBackStack(null)
            commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}