package com.til.tracking.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.til.tracking.R
import com.til.tracking.databinding.FTrackingDetailBinding
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * Description : HTTP 트래킹 상세 보기 화면
 *
 * Created by juhongmin on 2022/04/01
 */
class TrackingDetailFragment : Fragment() {
    companion object {
        fun newInstance(): TrackingDetailFragment = TrackingDetailFragment()
    }

    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }

    private lateinit var binding: FTrackingDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DataBindingUtil.inflate<FTrackingDetailBinding>(
            inflater,
            R.layout.f_tracking_detail,
            container,
            false
        ).run {
            binding = this
            return@run root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}
