package com.hmju.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * Description : DataBinding 이 없는 ViewModel 기반의 Activity
 *
 * Created by juhongmin on 2022/02/26
 */
abstract class BaseActivity<VM : BaseViewModel>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        viewModel.onCreate()
    }
}