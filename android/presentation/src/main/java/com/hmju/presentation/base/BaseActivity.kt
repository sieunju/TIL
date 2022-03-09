package com.hmju.presentation.base

import android.os.Bundle
import androidx.annotation.CallSuper
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

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<B>(this, layoutId).apply {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.vm, viewModel)
        }
        Timber.d("${javaClass.simpleName} onCreate $isInit")
        lifecycle().onInit()
        viewModel.performOnCreated()
    }

    override fun onResume() {
        super.onResume()
        Timber.d("${javaClass.simpleName} onResume $isInit")
        if (isInit) {
            lifecycle().onVisible()
            viewModel.performOnResumed()
        }
        isInit = true
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop")
        lifecycle().onInVisible()
        viewModel.performOnStopped()
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("${javaClass.simpleName} onDestroy $isInit")
        viewModel.clearDisposable()
        isInit = false
        lifecycle().onRelease()
    }
}
