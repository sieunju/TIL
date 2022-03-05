package com.hmju.presentation.mvvm_lifecycle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseFragment
import com.hmju.presentation.databinding.FMvvmLifecycleBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/26
 */
@AndroidEntryPoint
class MvvmLifecycleFragment : BaseFragment<LifecycleViewModel, FMvvmLifecycleBinding>(
    R.layout.f_mvvm_lifecycle
) {

    override val viewModel: LifecycleViewModel by viewModels()
    override val binding: FMvvmLifecycleBinding by viewBinding()

    private lateinit var callback : OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if(childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                } else {
                    parentFragmentManager.popBackStack()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this,callback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            moveFragment.observe(viewLifecycleOwner) {
                moveFragment(MvvmLifecycleTestFragment())
            }

            moveActivity.observe(viewLifecycleOwner) {
                Intent(requireContext(),MvvmLifecycleTestActivity::class.java).apply {
                    startActivity(this)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume!!@!@!@!@! ")
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

    private fun moveFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction().apply {
            replace(R.id.clRoot,fragment)
            addToBackStack(null)
            commit()
        }
    }
}
