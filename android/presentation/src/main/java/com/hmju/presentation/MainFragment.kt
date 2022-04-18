package com.hmju.presentation

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.hmju.presentation.custompaging.CustomPagingFragment
import com.hmju.presentation.databinding.FMainBinding
import com.hmju.presentation.json_jsend.JsonJsendFragment
import com.hmju.presentation.mvvm_lifecycle.MvvmLifecycleFragment
import com.hmju.presentation.performance_diff_util.DiffUtilPerformanceFragment
import com.hmju.presentation.refactor_base.RefactorBaseTestFragment
import com.hmju.presentation.refactor_diff_util.RefactorDiffUtilFragment
import com.hmju.presentation.refreshtoken.RefreshTokenFragment
import com.hmju.presentation.simple_like_recyclerview.SimpleLikeRecyclerViewFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.f_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<FMainBinding>(view)!!

        binding.expiredToken.setOnClickListener {
            moveFragment(RefreshTokenFragment())
        }

        binding.simpleLike.setOnClickListener {
            moveFragment(SimpleLikeRecyclerViewFragment())
        }

        binding.customPaging.setOnClickListener {
            moveFragment(CustomPagingFragment())
        }

        binding.jsonJSend.setOnClickListener {
            moveFragment(JsonJsendFragment())
        }

        binding.refactorDiffUtil.setOnClickListener {
            moveFragment(RefactorDiffUtilFragment())
        }

        binding.performDiffUtil.setOnClickListener {
            moveFragment(DiffUtilPerformanceFragment())
        }

        binding.mvvmLifecycle.setOnClickListener {
            moveFragment(MvvmLifecycleFragment())
        }

        binding.baseRefactor.setOnClickListener {
            moveFragment(RefactorBaseTestFragment())
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
