package com.hmju.domain.repository

import com.til.model.base.*
import com.til.model.meta.CustomMetaEntity
import com.til.model.test.JSendTestEntity
import io.reactivex.rxjava3.core.Single

/**
 * Description : JSend Repository
 *
 * Created by juhongmin on 2022/02/11
 */
interface JSendRepository {
    fun fetchJSend(): Single<JSendObj<JSendTestEntity>>
    fun fetchJSendWithMeta(): Single<JSendObjWithMeta<JSendTestEntity, CustomMetaEntity>>
    fun fetchJSendList(): Single<JSendList<String>>
    fun fetchJSendListWithMeta(): Single<JSendListWithMeta<String, MetaEntity>>
    fun fetchJSendListMeta(): Single<JSendListWithMeta<String, MetaEntity>>
    fun fetchSimpleJSendListMeta(): Single<JSendListWithMeta<String, CustomMetaEntity>>
    fun fetchErrorTest(): Single<JSendObjWithMeta<String, MetaEntity>>
}
