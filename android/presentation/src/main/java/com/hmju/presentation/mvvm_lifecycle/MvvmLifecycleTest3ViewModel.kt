package com.hmju.presentation.mvvm_lifecycle

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.hmju.domain.usecase.GetGoodsUseCase
import com.hmju.lifecycle.MovePage
import com.hmju.lifecycle.OnCreated
import com.hmju.presentation.base.BaseViewModel
import com.til.model.params.GoodsParamMap
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/03/12
 */
@HiltViewModel
class MvvmLifecycleTest3ViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getGoodsUseCase: GetGoodsUseCase
) : BaseViewModel() {

    @OnCreated
    fun start() {
        val queryMap = GoodsParamMap()
        getGoodsUseCase(queryMap)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Timber.d("SUCC $it")
            }, {
                Timber.e("Error $it")
            })
    }

    fun moveTest2Page() {
        startActivity.value = MovePage(
            MvvmLifecycleTest2Activity::class.java,
            bundle = Bundle().apply {
                putString("key3", "value3")
            }
        )
    }
}