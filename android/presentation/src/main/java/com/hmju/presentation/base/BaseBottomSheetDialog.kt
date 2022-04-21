package com.hmju.presentation.base

import android.content.DialogInterface
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
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hmju.lifecycle.*
import com.hmju.presentation.BR
import timber.log.Timber

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

    @CallSuper
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
            lifecycleOwner = this@BaseBottomSheetDialog
            setVariable(BR.vm, viewModel)
            this.root
        }
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.runCatching {
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
            addDisposable(performLifecycle<OnStopped>())
        }
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearDisposable()
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        Timber.d("onDismiss $dialog")
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
}
