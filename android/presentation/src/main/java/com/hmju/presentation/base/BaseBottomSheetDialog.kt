package com.hmju.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelLazy
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnResumed
import com.hmju.lifecycle.OnStopped
import com.hmju.lifecycle.OnViewCreated
import com.hmju.presentation.BR

/**
 * Description : BaseBottomSheetDialog
 *
 * Created by juhongmin on 2022/04/15
 */
abstract class BaseBottomSheetDialog<T : ViewDataBinding, VM : BottomSheetViewModel>(
    @LayoutRes private val layoutId: Int
) : BottomSheetDialogFragment() {

    abstract val viewModel: VM
    var binding: T by autoCleared()

    private var isInit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.runCatching {
            addDisposable(performLifecycle<OnCreated>())
        }

        dialog?.setOnDismissListener {
            dismiss()
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
        viewModel.clearDisposable()
    }

    /**
     * 기본 viewModels 와 같은 로직의 함수
     */
    protected inline fun <reified VM : BottomSheetViewModel> initViewModel(): Lazy<VM> {
        return ViewModelLazy(VM::class, { viewModelStore }, { defaultViewModelProviderFactory })
    }
}
