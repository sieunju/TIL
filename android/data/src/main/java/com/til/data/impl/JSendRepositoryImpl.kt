package com.til.data.impl

import com.hmju.domain.repository.JSendRepository
import com.til.data.network.JSendApiService
import com.til.model.base.*
import com.til.model.test.JSendTestEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/11
 */
class JSendRepositoryImpl @Inject constructor(
    private val apiService: JSendApiService
) : JSendRepository {
    override fun fetchJSend(): Single<JSendResponse<JSendTestEntity>> {
        return apiService.fetchJSend()
    }

    override fun fetchJSendWithMeta(): Single<JSendWithMetaResponse<JSendTestEntity, CustomMetaEntity>> {
        return apiService.fetchJSendWithMeta()
    }

    override fun fetchJSendList(): Single<JSendListResponse<List<String>>> {
        return apiService.fetchJSendList()
    }

    override fun fetchJSendListWithMeta(): Single<JSendListWithMetaResponse<List<String>, CustomMetaEntity>> {
        return apiService.fetchJSendListWithMeta()
    }
}
