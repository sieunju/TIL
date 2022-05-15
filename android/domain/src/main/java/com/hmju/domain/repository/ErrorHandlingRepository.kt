package com.hmju.domain.repository

import com.til.model.base.*
import com.til.model.meta.CustomMetaEntity
import io.reactivex.rxjava3.core.Single

/**
 * Description : 에러 헨들링 전용 Repository Interface
 *
 * Created by juhongmin on 2022/05/12
 */
interface ErrorHandlingRepository {
    fun getError505(): Single<Nothing>
    fun postError505(): Single<Nothing>
    fun getError404(): Single<Nothing>
    fun postError404(): Single<Nothing>
    fun fetchJSendListWithMeta(): Single<JSendListWithMeta<String, CustomMetaEntity>>
}