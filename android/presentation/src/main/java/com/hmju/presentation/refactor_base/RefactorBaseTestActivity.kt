package com.hmju.presentation.refactor_base

import com.hmju.presentation.R
import com.hmju.core.BaseActivity
import com.hmju.presentation.BR
import com.hmju.presentation.databinding.ARefactorBaseTestBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description : StartResult Test 용 액티비티
 *
 * Created by juhongmin on 2022/03/19
 */
@AndroidEntryPoint
class RefactorBaseTestActivity : BaseActivity<ARefactorBaseTestBinding, RefactorTestViewModel>
    (R.layout.a_refactor_base_test) {

    override val viewModel: RefactorTestViewModel by initViewModel()
    override val bindingVariable: Int = BR.vm
}
