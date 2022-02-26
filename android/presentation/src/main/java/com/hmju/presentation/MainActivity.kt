package com.hmju.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hmju.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        intent.putExtra("KEY","AAFEFEFEFE")
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, MainFragment())
            addToBackStack(null)
            commit()
        }
    }
}