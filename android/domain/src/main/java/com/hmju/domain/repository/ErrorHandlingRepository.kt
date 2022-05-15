package com.hmju.domain.repository

import com.til.model.base.*
import com.til.model.test.JSendTestEntity
import io.reactivex.rxjava3.core.Single

/**
 * Description : 에러 헨들링 전용 Repository Interface
 *
 * Created by juhongmin on 2022/05/12
 */
interface ErrorHandlingRepository {
    fun getError505(): Single<JSend<String>>
    fun postError505(): Single<JSend<String>>
    fun getError404(): Single<JSend<String>>
    fun postError404(): Single<JSend<String>>
    fun fetchJSendListWithMeta(): Single<JSendListWithMeta<String, CustomMetaEntity>>
}