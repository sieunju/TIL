package com.hmju.presentation.error_handling

import com.hmju.presentation.R
import com.hmju.presentation.base.BaseFragment
import com.hmju.presentation.databinding.FErrorHandlingBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description : HTTP API 에러 핸들링 Fragment
 *
 * Created by juhongmin on 2022/05/12
 */
@AndroidEntryPoint
class ErrorHandlingFragment : BaseFragment<FErrorHandlingBinding, ErrorHandlingViewModel>(
    R.layout.f_error_handling
) {
    override val viewModel: ErrorHandlingViewModel by initViewModel()
}
