package com.hmju.presentation.refactor_base

import android.os.Bundle
import android.view.View
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseFragmentV2
import com.hmju.presentation.databinding.FRefactorBaseTestBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/15
 */
@AndroidEntryPoint
class RefactorBaseTestFragment : BaseFragmentV2<FRefactorBaseTestBinding,RefactorTestFragmentViewModel>
    (R.layout.f_refactor_base_test){

    override val viewModel: RefactorTestFragmentViewModel by initViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
//            button.setOnClickListener {
//                Single.just("메모리 누수 체크")
//                    .delay(3000,TimeUnit.MILLISECONDS)
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe({
//                        Timber.d("여기옴????")
//                        binding.button.text = it
//                    },{
//                        Timber.d("Error $it")
//                    })
//            }
        }
    }
}
