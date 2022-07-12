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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnResumed
import com.hmju.lifecycle.OnStopped
import com.hmju.lifecycle.OnViewCreated
import timber.log.Timber

/**
 * Description : BottomSheet 에서 ParentFragment Shared 할수 있는 Dialog
 *
 * Created by juhongmin on 2022/04/19
 */
abstract class BaseSharedBottomSheetDialog<T : ViewDataBinding, VM : BottomSheetViewModel>(
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
            lifecycleOwner = this@BaseSharedBottomSheetDialog
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
        if (isInit) {
            viewModel.runCatching {
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

    @CallSuper
    override fun dismiss() {
        super.dismiss()
        Timber.d("${javaClass.simpleName} Dismiss")
    }

    fun simpleShow(fm: FragmentManager) {
        super.show(fm, javaClass.simpleName)
        Timber.d("FragmentCnt ${fm.fragments.size}")
    }

    /**
     * SharedBottomSheet 전용 ViewModel onCreate 에서 실행 해야 한다
     */
    protected inline fun <reified VM : BottomSheetViewModel> initBottomSheetViewModel(): VM {
        return ViewModelProvider(viewModelStore, defaultViewModelProviderFactory).get()
    }
}