package com.hmju.presentation.refactor_base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hmju.presentation.R
import com.hmju.core.BaseFragment
import com.hmju.presentation.BR
import com.hmju.presentation.databinding.FRefactorBaseRootTestBinding
import com.hmju.presentation.refactor_base.child.ChildRefactorBlueFragment
import com.hmju.presentation.refactor_base.child.ChildRefactorRedFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description : BaseClass 리펙토링 관련 RootFragment
 *
 * Created by juhongmin on 2022/04/15
 */
@AndroidEntryPoint
class RefactorBaseRootTestFragment
    : BaseFragment<FRefactorBaseRootTestBinding, RefactorBaseRootTestViewModel>
    (R.layout.f_refactor_base_root_test) {

    override val viewModel: RefactorBaseRootTestViewModel by initViewModel()
    override val bindingVariable: Int = BR.vm

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val adapter = PagerAdapter(this@RefactorBaseRootTestFragment)
            vp.adapter = adapter
        }
    }

    class PagerAdapter(fm: Fragment) : FragmentStateAdapter(fm) {
        override fun getItemCount() = 2

        override fun createFragment(pos: Int): Fragment {
            return when (pos) {
                0 -> ChildRefactorBlueFragment.newInstance()
                else -> ChildRefactorRedFragment()
            }
        }
    }
}
