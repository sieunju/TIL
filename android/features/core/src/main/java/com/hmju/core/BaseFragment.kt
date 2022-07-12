package com.hmju.core

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModelProvider
import com.hmju.lifecycle.*
import timber.log.Timber

/**
 * Description : MVVM BaseFragment
 *
 * Created by juhongmin on 2022/03/19
 */
abstract class BaseFragment<T : ViewDataBinding, VM : FragmentViewModel>(
    @LayoutRes private val layoutId: Int
) : Fragment() {

    abstract val viewModel: VM
    abstract val bindingVariable : Int // ViewModel Binding Variable
    var binding: T by autoCleared()

    private var isInit = false

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.runCatching {
            onDirectCreate()
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
            lifecycleOwner = this@BaseFragment
            setVariable(bindingVariable, viewModel)
            this.root
        }
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.runCatching {
            onDirectViewCreated()
            addDisposable(performLifecycle<OnViewCreated>())
        }

        with(viewModel) {
            startActivityPage.observe(viewLifecycleOwner) {
                Intent(requireContext(), it.targetActivity.java).apply {
                    if (it.flags != -1) {
                        flags = it.flags
                    }
                    putExtras(it.data)

                    startActivity(this)
                }
            }
        }
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        viewModel.runCatching {
            onDirectResumed()
            addDisposable(performLifecycle<OnCreatedToResumed>())

            if (isInit) {
                addDisposable(performLifecycle<OnResumed>())
            }
        }
        isInit = true
    }

    @CallSuper
    override fun onStop() {
        super.onStop()
        viewModel.runCatching {
            onDirectStop()
            addDisposable(performLifecycle<OnStopped>())
        }
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        isInit = false
        viewModel.clearDisposable()

        Timber.d("onDestroyView ${javaClass.simpleName}")
    }

    @CallSuper
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
        Timber.d("onDestroy ${javaClass.simpleName}")
    }

    /**
     * 기본 viewModels 와 같은 로직의 함수
     */
    protected inline fun <reified VM : FragmentViewModel> initViewModel(): Lazy<VM> {
        return createViewModelLazy(VM::class, { viewModelStore })
    }

    /**
     * Parent Fragment ViewModel 공유하기위한 함수
     * Lazy 로 선언한하고 직접적으로 가져올때 사용하는 함수
     */
    protected inline fun <reified VM : BaseViewModel> parentViewModel(parentFragment: Fragment): VM {
        return ViewModelProvider(
            parentFragment.viewModelStore,
            parentFragment.defaultViewModelProviderFactory
        ).get(VM::class.java)
    }
}
