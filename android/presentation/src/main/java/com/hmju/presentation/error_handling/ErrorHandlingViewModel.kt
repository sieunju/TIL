package com.hmju.presentation.error_handling

import com.hmju.domain.repository.ErrorHandlingRepository
import com.hmju.domain.repository.JSendRepository
import com.hmju.presentation.base.FragmentViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.kotlin.addTo
import timber.log.Timber
import javax.inject.Inject

/**
 * Description : HTTP 에러 헨들링 ViewModel
 *
 * Created by juhongmin on 2022/05/12
 */
@HiltViewModel
class ErrorHandlingViewModel @Inject constructor(
    private val errorHandlingRepository: ErrorHandlingRepository,
    private val jSendRepository: JSendRepository
) : FragmentViewModel() {


    fun performGet505() {
//        jSendRepository.fetchJSend().subscribe().addTo(compositeDisposable)
        jSendRepository.fetchJSend().subscribe({
            Timber.d("다 왔습니다. $it")
        }, {

        }).addTo(compositeDisposable)
        errorHandlingRepository.fetchJSendListWithMeta().subscribe({
            Timber.d("여깁니다 $it")
        }, {}).addTo(compositeDisposable)
        jSendRepository.fetchSimpleJSendListMeta()
            .map {
                Timber.d("Map Thread ${Thread.currentThread()}")
                return@map it
            }
            .subscribe({
                Timber.d("Thread ${Thread.currentThread()}")
                Timber.d("SUCC ${it}")
            }, {

            }).addTo(compositeDisposable)
//        errorHandlingRepository.getError505()
//            .subscribe({
//            },{
//
//            })
//            .addTo(compositeDisposable)
    }

    fun performPost505() {
        errorHandlingRepository.postError505()
            .subscribe()
            .addTo(compositeDisposable)
    }

    fun performGet404() {
        errorHandlingRepository.getError404()
            .subscribe()
            .addTo(compositeDisposable)
    }

    fun performPost404() {
        errorHandlingRepository.postError404()
            .subscribe()
            .addTo(compositeDisposable)
    }
}
