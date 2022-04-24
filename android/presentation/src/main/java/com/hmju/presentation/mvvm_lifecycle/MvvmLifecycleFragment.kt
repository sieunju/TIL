package com.hmju.presentation.mvvm_lifecycle

import android.content.Context
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseFragment
import com.hmju.presentation.databinding.FMvvmLifecycleBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/26
 */
@AndroidEntryPoint
class MvvmLifecycleFragment : BaseFragment<FMvvmLifecycleBinding, LifecycleViewModel>(
    R.layout.f_mvvm_lifecycle
) {

    override val viewModel: LifecycleViewModel by initViewModel()

    private lateinit var callback: OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                } else {
                    parentFragmentManager.popBackStack()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

    private fun moveFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction().apply {
            replace(R.id.clRoot, fragment)
            addToBackStack(null)
            commit()
        }
    }
}
