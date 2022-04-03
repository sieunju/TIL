package com.til.tracking.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.til.tracking.Extensions
import com.til.tracking.R
import com.til.tracking.databinding.FTrackingDetailRequestBinding
import com.til.tracking.entity.TrackingHttpEntity
import com.til.tracking.models.BaseTrackingUiModel
import com.til.tracking.models.TrackingPathUiModel
import com.til.tracking.models.TrackingTitleUiModel
import com.til.tracking.rx.TrackingDetailEvent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/02
 */
internal class TrackingDetailRequestFragment : Fragment() {

    companion object {
        fun newInstance(): TrackingDetailRequestFragment = TrackingDetailRequestFragment()
    }

    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }

    private lateinit var binding: FTrackingDetailRequestBinding
    private val adapter: Extensions.TrackingDetailAdapter by lazy { Extensions.TrackingDetailAdapter() }

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
        with(binding) {
            rvContents.adapter = adapter
        }
        TrackingDetailEvent.listen()
            .map { parseUiModel(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Timber.d("Request Data ${it.size}")
                adapter.submitList(it)
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

    private fun parseUiModel(entity: TrackingHttpEntity): List<BaseTrackingUiModel> {
        val uiList = mutableListOf<BaseTrackingUiModel>()
        uiList.add(TrackingTitleUiModel("[Path]"))
        uiList.add(TrackingPathUiModel(entity.path))
        if (entity.headerMap.isNotEmpty()) {
            uiList.add(TrackingTitleUiModel("[Header]"))
            uiList.addAll(Extensions.parseHeaderUiModel(entity.headerMap))
        }
        if (!entity.req.query.isNullOrEmpty()) {
            uiList.add(TrackingTitleUiModel("[Query]"))
            uiList.addAll(Extensions.parseQueryUiModel(entity.req.query))
        }
        entity.req.body?.let { body->
            uiList.add(TrackingTitleUiModel("[Body]"))
            uiList.add(Extensions.parseBodyUiModel(body))
        }
        return uiList
    }
}
