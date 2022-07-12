package com.hmju.presentation.refactor_diff_util_v2

import com.hmju.domain.usecase.GetGoodsUseCase
import com.hmju.lifecycle.OnViewCreated
import com.hmju.core.FragmentViewModel
import com.hmju.presentation.custompaging.ListLiveData
import com.hmju.presentation.custompaging.PagingModel
import com.hmju.presentation.refactor_diff_util.BaseUiModel
import com.hmju.presentation.refactor_diff_util.GoodsOneUiModel
import com.hmju.presentation.refactor_diff_util.GoodsTwoUiModel
import com.til.model.params.GoodsParamMap
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class DiffUtil2ViewModel @Inject constructor(
    private val getGoodsUseCase: GetGoodsUseCase
) : FragmentViewModel() {

    private val _dataList: ListLiveData<BaseUiModel> by lazy { ListLiveData() }
    val dataList: ListLiveData<BaseUiModel> get() = _dataList

    val pagingModel: PagingModel by lazy { PagingModel() }
    private val queryMap: GoodsParamMap by lazy { GoodsParamMap() }

    @OnViewCreated
    fun onStart(){
        fetchGoods()
    }

    private fun fetchGoods(){
        getGoodsUseCase(queryMap)
            .doOnSubscribe { pagingModel.isLoading = true }
            .map { list ->
                val uiList = mutableListOf<BaseUiModel>()
                list.forEach {
                    uiList.add(
                        if (Random.nextBoolean()) {
                            GoodsOneUiModel(it)
                        } else {
                            GoodsTwoUiModel(it)
                        }
                    )
                }
                return@map uiList
            }.observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                queryMap.pageNo++
                pagingModel.isLast = it.isEmpty()
                pagingModel.isLoading = false
                _dataList.addAll(it)
            },{
                pagingModel.isLast = true
            }).addTo(compositeDisposable)
    }
}
