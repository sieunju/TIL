package com.hmju.presentation.refactor_base

import com.hmju.presentation.R
import com.hmju.presentation.base.BaseActivityV2
import com.hmju.presentation.databinding.ARefactorBaseTestBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description :
 *
 * Created by juhongmin on 2022/03/19
 */
@AndroidEntryPoint
class RefactorBaseTestActivity : BaseActivityV2<ARefactorBaseTestBinding, RefactorTestViewModel>
    (R.layout.a_refactor_base_test) {

    override val viewModel: RefactorTestViewModel by initViewModel()
}