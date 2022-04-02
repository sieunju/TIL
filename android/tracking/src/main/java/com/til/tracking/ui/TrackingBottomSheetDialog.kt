package com.til.tracking.ui

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.til.tracking.BR
import com.til.tracking.R
import com.til.tracking.databinding.DTrackingBottomSheetBinding
import com.til.tracking.ui.detail.TrackingDetailFragment
import com.til.tracking.ui.list.TrackingListFragment
import timber.log.Timber

/**
 * Description : HTTP 로그 정보 보여주는 BottomSheetDialog
 *
 * Created by juhongmin on 2022/03/29
 */
class TrackingBottomSheetDialog : BottomSheetDialogFragment() {

    companion object {
        var IS_SHOW = false
    }

    private val _title: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val title: LiveData<String> get() = _title

    private lateinit var binding: DTrackingBottomSheetBinding
    private lateinit var pagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomSheetStyle)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener { dialogInterface ->
            val bottomSheetDialog = dialogInterface as BottomSheetDialog
            setupRatio(bottomSheetDialog)
        }
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DataBindingUtil.inflate<DTrackingBottomSheetBinding>(
            inflater,
            R.layout.d_tracking_bottom_sheet,
            container,
            false
        ).run {
            lifecycleOwner = this@TrackingBottomSheetDialog
            binding = this
            binding.setVariable(BR.dialog, this@TrackingBottomSheetDialog)
            return@run root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        IS_SHOW = true
        pagerAdapter = PagerAdapter(requireActivity())
        _title.value = "목록"
        with(binding) {
            vp.isUserInputEnabled = false
            vp.adapter = pagerAdapter
        }

        dialog?.setOnDismissListener {
            dismiss()
        }
    }

    override fun dismiss() {
        IS_SHOW = false
        super.dismiss()
    }

    private fun setupRatio(bottomSheetDialog: BottomSheetDialog) {
        val bottomSheet =
            bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as View
        val behavior = BottomSheetBehavior.from(bottomSheet)
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = getBottomSheetHeight()
        bottomSheet.layoutParams = layoutParams
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    /**
     * Height 85%
     */
    private fun getBottomSheetHeight(): Int {
        return getDeviceHeight() * 85 / 100
    }

    private fun getDeviceHeight(): Int {
        val windowManager: WindowManager =
            requireContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            windowManager.currentWindowMetrics.bounds.height()
        } else {
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            displayMetrics.heightPixels
        }
    }

    class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(pos: Int): Fragment {
            return if (pos == 0) {
                TrackingListFragment.newInstance()
            } else {
                TrackingDetailFragment.newInstance()
            }
        }
    }
}
