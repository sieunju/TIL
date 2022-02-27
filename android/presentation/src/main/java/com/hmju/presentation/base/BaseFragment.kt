package com.hmju.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
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
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    abstract val viewModel: VM
    abstract val binding: B
    protected fun lifecycle(): LifecycleController = viewModel.lifecycleController

    private var isInit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate $isInit")
        viewModel.onCreate()
        lifecycle().onInit()
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding.apply {
//            lifecycleOwner = this@BaseFragment
//            setVariable(BR.vm, viewModel)
//        }
//        return binding.root
//    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume $isInit")
        if (isInit) {
            lifecycle().onVisible()
        }
        isInit = true
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = this@BaseFragment
            setVariable(BR.vm, viewModel)
        }
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
