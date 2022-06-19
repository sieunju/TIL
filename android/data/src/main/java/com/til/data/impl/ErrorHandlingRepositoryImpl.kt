package com.til.data.impl

import com.hmju.domain.repository.ErrorHandlingRepository
import com.til.data.network.ErrorHandlingApiService
import com.til.data.network.JSendApiService
import com.til.model.meta.CustomMetaEntity
import com.til.model.base.JSendListWithMeta
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/05/12
 */
internal class ErrorHandlingRepositoryImpl @Inject constructor(
    private val apiService : ErrorHandlingApiService,
    private val jsendApiService : JSendApiService
) : ErrorHandlingRepository {

    override fun getError505(): Single<Nothing> {
        return apiService.getError505()
    }

    override fun postError505(): Single<Nothing> {
        return apiService.postError505()
    }

    override fun getError404(): Single<Nothing> {
        return apiService.getError404()
    }

    override fun postError404(): Single<Nothing> {
        return apiService.postError404()
    }

    override fun fetchJSendListWithMeta(): Single<JSendListWithMeta<String, CustomMetaEntity>> {
        return jsendApiService.fetchSimpleJSendListMeta()
    }
}
