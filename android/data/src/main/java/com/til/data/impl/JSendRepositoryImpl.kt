package com.til.data.impl

import com.hmju.domain.repository.JSendRepository
import com.til.data.network.JSendApiService
import com.til.model.base.*
import com.til.model.meta.CustomMetaEntity
import com.til.model.test.JSendTestEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/11
 */
internal class JSendRepositoryImpl @Inject constructor(
    private val apiService: JSendApiService
) : JSendRepository {
    override fun fetchJSend(): Single<JSendSimpleObj<JSendTestEntity>> {
        return apiService.fetchJSend()
    }

    override fun fetchJSendWithMeta(): Single<JSendSimpleObjWithMeta<JSendTestEntity, CustomMetaEntity>> {
        return apiService.fetchJSendWithMeta()
    }

    override fun fetchJSendList(): Single<JSendSimpleList<String>> {
        return apiService.fetchJSendList()
    }

    override fun fetchJSendListWithMeta(): Single<JSendSimpleListWithMeta<String, MetaEntity>> {
        return apiService.fetchJSendListWithMeta()
    }

    override fun fetchJSendListMeta(): Single<JSendSimpleListWithMeta<String, MetaEntity>> {
        return apiService.fetchJSendListWithMeta()
    }

    override fun fetchSimpleJSendListMeta(): Single<JSendSimpleListWithMeta<String, CustomMetaEntity>> {
        return apiService.fetchSimpleJSendListMeta()
    }
}
