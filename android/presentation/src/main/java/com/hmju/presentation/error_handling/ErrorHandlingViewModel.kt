package com.hmju.presentation.error_handling

import com.hmju.domain.repository.ErrorHandlingRepository
import com.hmju.presentation.base.FragmentViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

/**
 * Description : HTTP 에러 헨들링 ViewModel
 *
 * Created by juhongmin on 2022/05/12
 */
@HiltViewModel
class ErrorHandlingViewModel @Inject constructor(
    private val errorHandlingRepository: ErrorHandlingRepository
) : FragmentViewModel() {


    fun performGet505(){
        errorHandlingRepository.getError505()
            .subscribe()
            .addTo(compositeDisposable)
    }

    fun performPost505(){
        errorHandlingRepository.postError505()
            .subscribe()
            .addTo(compositeDisposable)
    }

    fun performGet404(){
        errorHandlingRepository.getError404()
            .subscribe()
            .addTo(compositeDisposable)
    }

    fun performPost404(){
        errorHandlingRepository.postError404()
            .subscribe()
            .addTo(compositeDisposable)
    }
}
