package com.hmju.presentation.refactor_diff_util

import androidx.lifecycle.ViewModel
import com.hmju.domain.usecase.GetGoodsUseCase
import com.hmju.presentation.JLogger
import com.hmju.presentation.custompaging.ListLiveData
import com.hmju.presentation.custompaging.PagingModel
import com.til.model.goods.GoodsEntity
import com.til.model.params.GoodsParamMap
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class RefactorDiffUtilViewModel @Inject constructor(
    private val getGoodsUseCase: GetGoodsUseCase
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    private val _dataList: ListLiveData<BaseUiModel> by lazy { ListLiveData() }
    val dataList: ListLiveData<BaseUiModel> get() = _dataList

    val pagingModel: PagingModel by lazy { PagingModel() }
    private val queryMap: GoodsParamMap by lazy { GoodsParamMap() }

    fun start() {
        getGoodsUseCase(queryMap)
            .map { list ->
                val uiList = mutableListOf<BaseUiModel>()
                list.map {
                    if (Random.nextBoolean()) {
                        GoodsOneUiModel(it)
                    } else {
                        GoodsTwoUiModel(it)
                    }
                }
                uiList
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _dataList.clear()
                _dataList.addAll(it)
            }, {

            }).addTo(compositeDisposable)
    }

    fun onLoadNextPage(){
        getGoodsUseCase(queryMap)
            .doOnSubscribe { pagingModel.isLoading = true }
            .delay(500, TimeUnit.MILLISECONDS)
            .map { list ->
                val uiList = mutableListOf<BaseUiModel>()
                list.map {
                    if (Random.nextBoolean()) {
                        GoodsOneUiModel(it)
                    } else {
                        GoodsTwoUiModel(it)
                    }
                }
                uiList
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                JLogger.d("List ${it.size}")
                queryMap.pageNo++
                pagingModel.isLast = it.isEmpty()
                pagingModel.isLoading = false
                _dataList.addAll(it)
            }, {
                pagingModel.isLast = true
            }).addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}