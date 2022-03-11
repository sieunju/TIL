package com.hmju.presentation.base

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.PermissionChecker
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnResumed
import com.hmju.lifecycle.OnStopped
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

    private val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        Timber.d("Activity Result $it")
    }

    private val permissionResult = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
        Timber.d("Permission Result $it")
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<B>(this, layoutId).apply {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.vm, viewModel)
        }
        Timber.d("${javaClass.simpleName} onCreate $isInit")
        lifecycle().onInit()
        viewModel.performLifecycle<OnCreated>()
    }

    override fun onResume() {
        super.onResume()
        Timber.d("${javaClass.simpleName} onResume $isInit")
        if (isInit) {
            lifecycle().onVisible()
            viewModel.performLifecycle<OnResumed>()
        }
        isInit = true
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop")
        lifecycle().onInVisible()
        viewModel.performLifecycle<OnStopped>()
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("${javaClass.simpleName} onDestroy $isInit")
        viewModel.clearDisposable()
        isInit = false
        lifecycle().onRelease()
    }
}
