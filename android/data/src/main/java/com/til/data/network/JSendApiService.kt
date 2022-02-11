package com.til.data.network

import com.til.model.base.*
import com.til.model.test.JSendTestEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

/**
 * Description : JSend ApiService
 *
 * Created by juhongmin on 2022/02/11
 */
interface JSendApiService {
    @GET("/api/jsend")
    fun fetchJSend(): Single<JSendResponse<JSendTestEntity>>

    @GET("/api/jsend/meta")
    fun fetchJSendWithMeta(): Single<JSendWithMetaResponse<JSendTestEntity, CustomMetaEntity>>

    @GET("/api/jsend/list")
    fun fetchJSendList(): Single<JSendListResponse<List<String>>>

    @GET("/api/jsend/list/meta")
    fun fetchJSendListWithMeta(): Single<JSendListWithMetaResponse<List<String>, CustomMetaEntity>>
}