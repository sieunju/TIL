package com.hmju.presentation.json_jsend

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.hmju.presentation.R
import com.hmju.presentation.databinding.FJsonJsendBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * Description : JSON JSend 규칙에 대한 Fragment
 *
 * Created by juhongmin on 2022/01/25
 */
@AndroidEntryPoint
class JsonJsendFragment : Fragment(R.layout.f_json_jsend){

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FJsonJsendBinding>(view)?.run {

        }
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
