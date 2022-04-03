package com.til.tracking.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.til.tracking.Extensions
import com.til.tracking.R
import com.til.tracking.databinding.FTrackingDetailResponseBinding
import com.til.tracking.entity.TrackingHttpEntity
import com.til.tracking.models.BaseTrackingUiModel
import com.til.tracking.models.TrackingTitleUiModel
import com.til.tracking.rx.TrackingDetailEvent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

/**
 * Description : 상세 > Response Fragment
 *
 * Created by juhongmin on 2022/04/02
 */
class TrackingDetailResponseFragment : Fragment() {

    companion object {
        fun newInstance(): TrackingDetailResponseFragment = TrackingDetailResponseFragment()
    }

    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }

    private lateinit var binding: FTrackingDetailResponseBinding
    private val adapter: Extensions.TrackingDetailAdapter by lazy { Extensions.TrackingDetailAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DataBindingUtil.inflate<FTrackingDetailResponseBinding>(
            inflater,
            R.layout.f_tracking_detail_response,
            container,
            false
        ).run {
            binding = this
            return@run root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            rvContents.adapter = adapter
        }
        TrackingDetailEvent.listen()
            .map { parseUiModel(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Timber.d("Response Data $it")
                adapter.submitList(it)
            }, {

            }).addTo(disposable)
    }

    private fun parseUiModel(entity: TrackingHttpEntity): List<BaseTrackingUiModel> {
        val uiList = mutableListOf<BaseTrackingUiModel>()
        entity.res?.body?.let { body->
            uiList.add(TrackingTitleUiModel("[Body]"))
            uiList.add(Extensions.parseBodyUiModel(body))
        }
        return uiList
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}
