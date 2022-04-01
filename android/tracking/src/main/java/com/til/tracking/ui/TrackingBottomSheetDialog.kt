package com.til.tracking.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onStart() {
        super.onStart()
        if (dialog is BottomSheetDialog) {
            (dialog as BottomSheetDialog).runCatching {
                // behavior.state = BottomSheetBehavior.STATE_EXPANDED
                behavior.skipCollapsed = true
            }
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

    class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return 1
        }

        override fun createFragment(pos: Int): Fragment {
            return TrackingListFragment.newInstance()
        }
    }
}
