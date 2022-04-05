package com.hmju.presentation.custompaging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hmju.domain.usecase.GetGoodsUseCase
import com.hmju.presentation.base.BaseViewModel
import com.til.model.goods.GoodsEntity
import com.til.model.params.GoodsParamMap
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@HiltViewModel
class CustomPagingViewModel @Inject constructor(
    private val getGoodsUseCase: GetGoodsUseCase
) : BaseViewModel() {

    private val _pageNo: MutableLiveData<String> by lazy { MutableLiveData() }
    val pageNo: LiveData<String> get() = _pageNo

    private val _dataList: ListLiveData<GoodsEntity> by lazy { ListLiveData() }
    val dataList: ListLiveData<GoodsEntity> get() = _dataList

    val pagingModel: PagingModel by lazy { PagingModel() }
    private val queryMap: GoodsParamMap by lazy { GoodsParamMap() }

    fun start() {
        queryMap.tempQueryList = listOf("HIHIHI", "안녕하세요", "반갑습니다.")
        queryMap.tempQueryString = listOf("NO", "전체", "모던&포멀")
        getGoodsUseCase(queryMap)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _dataList.clear()
                _dataList.addAll(it)
            }, {
                Timber.e("Error $it")
            }).addTo(compositeDisposable)
    }

    fun onLoadNextPage() {
        Timber.d("Call onLoadNextPage $queryMap.pageNo")
        getGoodsUseCase(queryMap)
            .doOnSubscribe { pagingModel.isLoading = true }
            .delay(500, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Timber.d("List ${it.size}")
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
