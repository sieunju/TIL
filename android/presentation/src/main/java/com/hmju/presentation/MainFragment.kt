package com.hmju.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hmju.core.BaseFragment
import com.hmju.presentation.custompaging.CustomPagingFragment
import com.hmju.presentation.databinding.FMainBinding
import com.hmju.presentation.error_handling.ErrorHandlingFragment
import com.hmju.presentation.json_jsend.JsonJsendFragment
import com.hmju.presentation.mvvm_lifecycle.MvvmLifecycleFragment
import com.hmju.presentation.performance_diff_util.DiffUtilPerformanceFragment
import com.hmju.presentation.refactor_base.RefactorBaseRootTestFragment
import com.hmju.presentation.refactor_base.RefactorBaseTestActivity
import com.hmju.presentation.refactor_diff_util.RefactorDiffUtilFragment
import com.hmju.presentation.refactor_diff_util_v2.DiffUtil2Fragment
import com.hmju.presentation.refreshtoken.RefreshTokenFragment
import com.hmju.presentation.simple_like_recyclerview.SimpleLikeRecyclerViewFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FMainBinding, MainFragmentViewModel>(R.layout.f_main) {

    override val viewModel: MainFragmentViewModel by initViewModel()
    override val bindingVariable: Int = BR.vm

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            expiredToken.setOnClickListener {
                moveFragment(RefreshTokenFragment())
            }
            simpleLike.setOnClickListener {
                moveFragment(SimpleLikeRecyclerViewFragment())
            }
            customPaging.setOnClickListener {
                moveFragment(CustomPagingFragment())
            }
            jsonJSend.setOnClickListener {
                moveFragment(JsonJsendFragment())
            }
            refactorDiffUtil.setOnClickListener {
                moveFragment(RefactorDiffUtilFragment())
            }
            performDiffUtil.setOnClickListener {
                moveFragment(DiffUtilPerformanceFragment())
            }
            mvvmLifecycle.setOnClickListener {
                moveFragment(MvvmLifecycleFragment())
            }
            baseRefactor.setOnClickListener {
                moveFragment(RefactorBaseRootTestFragment())
            }
            baseRefactorAct.setOnClickListener {
                Intent(requireContext(), RefactorBaseTestActivity::class.java).apply {
                    putExtra(IntentKey.TOKEN, "randomToken")
                    startActivity(this)
                }
            }
            errorHandling.setOnClickListener {
                moveFragment(ErrorHandlingFragment())
            }
            diffUtilV2.setOnClickListener {
                moveFragment(DiffUtil2Fragment())
            }
        }
    }

    private fun moveFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, fragment)
            addToBackStack(null)
            commit()
        }
    }
}
