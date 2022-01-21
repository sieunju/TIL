package com.hmju.presentation.custompaging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hmju.domain.usecase.GetGoodsUseCase
import com.hmju.presentation.JLogger
import com.til.model.goods.GoodsEntity
import com.til.model.params.GoodsParamMap
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@HiltViewModel
class CustomPagingViewModel @Inject constructor(
    private val getGoodsUseCase: GetGoodsUseCase
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    private val _pageNo: MutableLiveData<String> by lazy { MutableLiveData() }
    val pageNo: LiveData<String> get() = _pageNo

    private val _dataList: ListLiveData<GoodsEntity> by lazy { ListLiveData() }
    val dataList: ListLiveData<GoodsEntity> get() = _dataList

    val pagingModel: PagingModel by lazy { PagingModel() }
    private val queryMap: GoodsParamMap by lazy { GoodsParamMap() }

    fun start() {
        getGoodsUseCase(queryMap)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _dataList.clear()
                _dataList.addAll(it)
            }, {
                JLogger.e("Error $it")
            }).addTo(compositeDisposable)
    }

    fun onLoadNextPage() {
        JLogger.d("Call onLoadNextPage ${queryMap.pageNo}")
        getGoodsUseCase(queryMap)
            .doOnSubscribe { pagingModel.isLoading = true }
            .delay(500,TimeUnit.MILLISECONDS)
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