package com.til.data.network

import com.til.model.base.JSend
import com.til.model.base.JSendBaseResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Description : 에러 헨들링 API 서비스
 *
 * Created by juhongmin on 2022/05/12
 */
interface ErrorHandlingApiService {
    @GET("/api/error/505")
    fun getError505(): Single<JSendBaseResponse<JSend<String>>>

    @POST("/api/error/505")
    fun postError505(): Single<JSendBaseResponse<JSend<String>>>

    @GET("/api/error/404")
    fun getError404(): Single<JSendBaseResponse<JSend<String>>>

    @POST("/api/error/404")
    fun postError404(): Single<JSendBaseResponse<JSend<String>>>
}
