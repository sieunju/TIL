package com.til.data.impl

import com.hmju.domain.repository.ErrorHandlingRepository
import com.til.data.network.ErrorHandlingApiService
import com.til.data.network.JSendApiService
import com.til.model.base.CustomMetaEntity
import com.til.model.base.JSend
import com.til.model.base.JSendListWithMeta
import com.til.model.base.MetaEntity
import com.til.model.test.JSendTestEntity
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
    override fun getError505(): Single<JSend<String>> {
        return apiService.getError505()
            .map { it.data ?: throw NullPointerException("Data is Null") }
    }

    override fun postError505(): Single<JSend<String>> {
        return apiService.postError505()
            .map { it.data ?: throw NullPointerException("Data is Null") }
    }

    override fun getError404(): Single<JSend<String>> {
        return apiService.getError404()
            .map { it.data ?: throw NullPointerException("Data is Null") }
    }

    override fun postError404(): Single<JSend<String>> {
        return apiService.postError404()
            .map { it.data ?: throw NullPointerException("Data is Null") }
    }

    override fun fetchJSendListWithMeta(): Single<JSendListWithMeta<String, CustomMetaEntity>> {
        return jsendApiService.fetchJSendListWithMetaTest()
    }
}
