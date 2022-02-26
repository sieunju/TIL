package com.hmju.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.hmju.presentation.JLogger

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/26
 */
abstract class BaseFragment<VM : BaseViewModel>(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        JLogger.d("onViewCreated!!")
    }
}