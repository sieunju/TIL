package com.hmju.presentation.refactor_base.bottomsheet

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseBottomSheetDialog
import com.hmju.presentation.databinding.DRefactorBottomSheetBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/18
 */
@AndroidEntryPoint
class RefactorBottomSheetDialog
    : BaseBottomSheetDialog<DRefactorBottomSheetBinding, RefactorBottomSheetViewModel>(
    R.layout.d_refactor_bottom_sheet
) {

    override val viewModel: RefactorBottomSheetViewModel by initViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomSheetDialog)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("Dialog $viewModel")
        with(binding) {
            vp.offscreenPageLimit = 2
            vp.isSaveEnabled = false
            val adapter = PagerAdapter(this@RefactorBottomSheetDialog)
            vp.adapter = adapter
        }

        with(viewModel) {
            startDismiss.observe(viewLifecycleOwner) {
                dismiss()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy")
    }


    class PagerAdapter(fm: Fragment) : FragmentStateAdapter(fm) {
        override fun getItemCount() = 2

        override fun createFragment(pos: Int): Fragment {
            return when (pos) {
                0 -> ChildBottomSheetBlueFragment.newInstance()
                else -> ChildBottomSheetRedFragment.newInstance()
            }
        }
    }
}
