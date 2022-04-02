package com.til.tracking.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.til.tracking.R
import com.til.tracking.databinding.FTrackingDetailRequestBinding
import com.til.tracking.rx.TrackingDetailEvent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import timber.log.Timber

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/02
 */
class TrackingDetailRequestFragment : Fragment() {

    companion object {
        fun newInstance(): TrackingDetailRequestFragment = TrackingDetailRequestFragment()
    }

    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }

    private lateinit var binding: FTrackingDetailRequestBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DataBindingUtil.inflate<FTrackingDetailRequestBinding>(
            inflater,
            R.layout.f_tracking_detail_request,
            container,
            false
        ).run {
            binding = this
            return@run root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TrackingDetailEvent.listen()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Timber.d("Request Data $it")
            }, {

            }).addTo(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}
