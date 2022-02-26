package com.hmju.presentation.refactor_diff_util

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hmju.presentation.BR
import com.hmju.presentation.R
import com.hmju.presentation.databinding.FRefactorDiffUtilBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description : DiffUtil Fragment
 *
 * Created by juhongmin on 2022/02/16
 */
@AndroidEntryPoint
class RefactorDiffUtilFragment : Fragment(R.layout.f_refactor_diff_util) {

    private val viewModel: RefactorDiffUtilViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FRefactorDiffUtilBinding>(view)?.run {
            lifecycleOwner = this@RefactorDiffUtilFragment
            setVariable(BR.vm, viewModel)
        }

        with(viewModel) {
            start()
        }
    }
}