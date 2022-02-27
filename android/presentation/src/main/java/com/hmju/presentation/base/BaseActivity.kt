package com.hmju.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.hmju.presentation.BR
import com.hmju.presentation.lifecycle.LifecycleController
import timber.log.Timber

/**
 * Description : DataBinding 이 없는 ViewModel 기반의 Activity
 *
 * Created by juhongmin on 2022/02/26
 */
abstract class BaseActivity<VM : BaseViewModel, B : ViewDataBinding>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {

    abstract val viewModel: VM
    lateinit var binding: B

    private var isInit = false
    protected fun lifecycle(): LifecycleController = viewModel.lifecycleController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<B>(this, layoutId).apply {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.vm, viewModel)
        }
        Timber.d("onCreate $isInit")
        viewModel.onCreate()
        lifecycle().onInit()
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume $isInit")
        if (isInit) {
            lifecycle().onVisible()
        }
        isInit = true
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop")
        lifecycle().onInVisible()
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy $isInit")
        viewModel.clearDisposable()
        isInit = false
        lifecycle().onRelease()
    }
}
