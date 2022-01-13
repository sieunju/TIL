package com.hmju.presentation.refreshtoken

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.hmju.domain.usecase.GetExpiredTokenUseCase
import com.hmju.domain.usecase.GetRefreshTokenUseCase
import com.hmju.presentation.R
import com.hmju.presentation.databinding.FRefreshTokenBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/12
 */
@AndroidEntryPoint
class RefreshTokenFragment : Fragment(R.layout.f_refresh_token) {

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    @Inject
    lateinit var getRefreshTokenUseCase: GetRefreshTokenUseCase

    @Inject
    lateinit var getExpiredTokenUseCase: GetExpiredTokenUseCase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FRefreshTokenBinding>(view)?.run {
            refresh.setOnClickListener {
//                refreshTokenUseCase()
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe({
//                        JLogger.d("Response $it")
//                    }, {
//                        JLogger.e("Error $it")
//                    }).addTo(compositeDisposable)
            }

            expired.setOnClickListener {
//                expiredTokenUseCase().observeOn(AndroidSchedulers.mainThread())
//                    .subscribe({
//                        JLogger.d("Response $it")
//                    }, {
//                        JLogger.e("Error $it")
//                    }).addTo(compositeDisposable)
            }
        }

    }
}