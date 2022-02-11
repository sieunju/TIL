package com.hmju.domain.usecase

import com.hmju.domain.repository.JSendRepository
import com.til.model.base.JSendListResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/11
 */
class GetJSendListUseCase @Inject constructor(
    private val repository: JSendRepository
){
    operator fun invoke() : Single<JSendListResponse<List<String>>> {
        return repository.fetchJSendList()
    }
}