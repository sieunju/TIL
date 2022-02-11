package com.hmju.presentation.json_jsend

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.hmju.domain.usecase.GetJSendListUseCase
import com.hmju.domain.usecase.GetJSendListWithMetaUseCase
import com.hmju.domain.usecase.GetJSendUseCase
import com.hmju.domain.usecase.GetJSendWithMetaUseCase
import com.hmju.presentation.R
import com.hmju.presentation.databinding.FJsonJsendBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

/**
 * Description : JSON JSend 규칙에 대한 Fragment
 *
 * Created by juhongmin on 2022/01/25
 */
@AndroidEntryPoint
class JsonJsendFragment : Fragment(R.layout.f_json_jsend) {

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }
    private lateinit var binding: FJsonJsendBinding

    @Inject
    lateinit var getJSendUseCase: GetJSendUseCase

    @Inject
    lateinit var getJSendWithMetaUseCase: GetJSendWithMetaUseCase

    @Inject
    lateinit var getJSendListUseCase: GetJSendListUseCase

    @Inject
    lateinit var getJSendListWithMetaUseCase: GetJSendListWithMetaUseCase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FJsonJsendBinding.bind(view)
        binding.jsend.setOnClickListener {
            getJSendUseCase()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    setText(it)
                }, {
                    setText(it)
                }).addTo(compositeDisposable)
        }

        binding.jsendMeta.setOnClickListener {
            getJSendWithMetaUseCase()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    setText(it)
                }, {
                    setText(it)
                }).addTo(compositeDisposable)
        }

        binding.jsendList.setOnClickListener {
            getJSendListUseCase()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    setText(it)
                }, {
                    setText(it)
                }).addTo(compositeDisposable)
        }

        binding.jsendListMeta.setOnClickListener {
            getJSendListWithMetaUseCase()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    setText(it)
                }, {
                    setText(it)
                }).addTo(compositeDisposable)
        }
    }

    private fun setText(entity: Any) {
        binding.tvResponse.text = entity.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}
