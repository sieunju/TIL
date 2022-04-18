package com.hmju.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnViewCreated

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
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.runCatching {
            addDisposable(performLifecycle<OnViewCreated>())
        }
    }
}
