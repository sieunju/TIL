package com.hmju.presentation.base

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.TextViewCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.hmju.presentation.BR
import com.hmju.presentation.R
import com.hmju.presentation.databinding.ActivityMvvmLifecycleTest3Binding
import com.hmju.presentation.mvvm_lifecycle.MvvmLifecycleTestViewModel
import kotlin.reflect.KClass

/**
 * Description : BaseActivity 를 상속 받을떄 Annotation 을 사용하여 좀더 깔끔하게 처리하는 BaseActivity Class
 *
 * Created by juhongmin on 2022/03/19
 */
abstract class BaseActivityV2<T : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {

    lateinit var binding: T
    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performBinding()
    }

    /**
     * 기본 viewModels 와 같은 로직의 함수
     */
    protected inline fun <reified VM : BaseViewModel> initViewModel(): Lazy<VM> {
        return ViewModelLazy(VM::class, { viewModelStore }, { defaultViewModelProviderFactory })
    }

    private fun performBinding() {
        binding = DataBindingUtil.setContentView<T>(this, layoutId).apply {
            lifecycleOwner = this@BaseActivityV2
            setVariable(BR.vm, viewModel)
        }
    }
}
