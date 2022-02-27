package com.hmju.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.hmju.presentation.BR
import com.hmju.presentation.lifecycle.LifecycleController
import timber.log.Timber

/**
 * Description : BaseFragment Class
 *
 * Created by juhongmin on 2022/02/26
 */
abstract class BaseFragment<VM : BaseViewModel, B : ViewDataBinding>(
    @LayoutRes private val layoutId: Int
) : Fragment() {

    abstract val viewModel: VM
    lateinit var binding: B

    private var isInit = false
    protected fun lifecycle(): LifecycleController = viewModel.lifecycleController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate $isInit")
        viewModel.onCreate()
        lifecycle().onInit()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<B>(inflater, layoutId, container, false).apply {
            lifecycleOwner = this@BaseFragment
            setVariable(BR.vm, viewModel)
        }
        return binding.root
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

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("onDestroyView $isInit")
        isInit = false
        viewModel.clearDisposable()
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy")
        lifecycle().onRelease()
    }
}
