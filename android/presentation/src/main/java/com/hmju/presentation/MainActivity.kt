package com.hmju.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.hmju.presentation.base.BaseActivity
import com.hmju.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        intent.putExtra("KEY", "AAFEFEFEFE")
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, MainFragment())
            addToBackStack(null)
            commit()
        }
    }
}
