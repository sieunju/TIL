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
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hmju.lifecycle.*
import timber.log.Timber

/**
 * Description : BaseBottomSheetDialog
 *
 * Created by juhongmin on 2022/04/15
 */
abstract class BaseBottomSheetDialog<T : ViewDataBinding, VM : BottomSheetViewModel>(
    @LayoutRes private val layoutId: Int
) : BottomSheetDialogFragment() {

    lateinit var viewModel: VM
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
            lifecycleOwner = this@BaseBottomSheetDialog
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

        dialog?.setOnDismissListener {
            dismiss()
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
        viewModel.clearDisposable()
    }

    @CallSuper
    override fun dismiss() {
        super.dismiss()
        Timber.d("${javaClass.simpleName} Dismiss")
    }

    fun simpleShow(fm: FragmentManager) {
        super.show(fm, javaClass.simpleName)
    }

    /**
     * 기본 viewModels 와 같은 로직의 함수
     */
    protected inline fun <reified VM : BottomSheetViewModel> initViewModel(): Lazy<VM> {
        return createViewModelLazy(VM::class, { viewModelStore })
    }

    /**
     * SharedBottomSheet 전용 ViewModel onCreate 에서 실행 해야 한다
     */
    protected inline fun <reified VM : BottomSheetViewModel> initBottomSheetViewModel(): VM {
        return ViewModelProvider(viewModelStore, defaultViewModelProviderFactory).get()
    }
}
