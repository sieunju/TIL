package com.hmju.domain.repository

import com.til.model.base.*
import com.til.model.test.JSendTestEntity
import io.reactivex.rxjava3.core.Single

/**
 * Description : JSend Repository
 *
 * Created by juhongmin on 2022/02/11
 */
interface JSendRepository {
    fun fetchJSend(): Single<JSendResponse<JSendTestEntity>>
    fun fetchJSendWithMeta(): Single<JSendWithMetaResponse<JSendTestEntity, CustomMetaEntity>>
    fun fetchJSendList(): Single<JSendListResponse<List<String>>>
    fun fetchJSendListWithMeta(): Single<JSendListWithMetaResponse<List<String>, CustomMetaEntity>>
}
