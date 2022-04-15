package com.hmju.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.hmju.lifecycle.*
import com.hmju.presentation.BR

/**
 * Description : MVVM BaseFragment
 *
 * Created by juhongmin on 2022/03/19
 */
abstract class BaseFragmentV2<T : ViewDataBinding, VM : FragmentViewModel>(
    @LayoutRes private val layoutId: Int
) : Fragment() {

    abstract val viewModel: VM
    var binding: T by autoCleared()

    private var isInit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.runCatching {
            addDisposable(performLifecycle<OnCreated>())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<T>(inflater, layoutId, container, false).run {
            binding = this
            lifecycleOwner = this@BaseFragmentV2
            setVariable(BR.vm, viewModel)
            this.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.runCatching {
            addDisposable(performLifecycle<OnViewCreated>())
        }
    }

    override fun onResume() {
        super.onResume()
        if (isInit) {
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

    override fun onDestroyView() {
        super.onDestroyView()
        isInit = false
        viewModel.clearDisposable()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            viewModel.runCatching {
                addDisposable(performLifecycle<OnFragmentShown>())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
