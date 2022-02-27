package com.hmju.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.hmju.presentation.lifecycle.LifecycleController
import com.hmju.presentation.lifecycle.LifecycleObserver
import com.hmju.presentation.lifecycle.RxLifecycleDelegate

/**
 * Description : DataBinding 이 없는 ViewModel 기반의 Activity
 *
 * Created by juhongmin on 2022/02/26
 */
abstract class BaseActivity<VM : BaseViewModel>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {

    abstract val viewModel: VM

    protected fun lifecycle() : LifecycleController = viewModel.lifecycleController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        viewModel.onCreate()
        lifecycle().onInit()
    }

    override fun onResume() {
        super.onResume()
        lifecycle().onVisible()
    }

    override fun onStop() {
        super.onStop()
        lifecycle().onInVisible()
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle().onRelease()
    }
}
