package com.hmju.presentation.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelLazy
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnResumed
import com.hmju.lifecycle.OnStopped
import com.hmju.presentation.BR

/**
 * Description : MVVM BaseActivity
 *
 * Created by juhongmin on 2022/03/19
 */
abstract class BaseActivityV2<T : ViewDataBinding, VM : ActivityViewModel>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {

    abstract val viewModel: VM
    lateinit var binding: T

    private var isInit = false

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performBinding()

        viewModel.runCatching {
            addDisposable(performLifecycle<OnCreated>())
        }
    }

    override fun onResume() {
        super.onResume()
        if(isInit) {
            viewModel.runCatching {
                addDisposable(performLifecycle<OnResumed>())
            }
        }
        isInit = true
    }

    override fun onStop() {
        super.onStop()
        viewModel.runCatching {
            addDisposable(performLifecycle<OnStopped>())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clearDisposable()
        isInit = false
    }

    /**
     * 기본 viewModels 와 같은 로직의 함수
     */
    protected inline fun <reified VM : ActivityViewModel> initViewModel(): Lazy<VM> {
        return ViewModelLazy(VM::class, { viewModelStore }, { defaultViewModelProviderFactory })
    }

    private fun performBinding() {
        binding = DataBindingUtil.setContentView<T>(this, layoutId).apply {
            lifecycleOwner = this@BaseActivityV2
            setVariable(BR.vm, viewModel)
        }
    }
}
