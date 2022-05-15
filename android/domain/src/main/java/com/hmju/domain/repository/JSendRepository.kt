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
    fun fetchJSend(): Single<JSendSimpleObj<JSendTestEntity>>
    fun fetchJSendWithMeta(): Single<JSendSimpleObjWithMeta<JSendTestEntity, CustomMetaEntity>>
    fun fetchJSendList(): Single<JSendSimpleList<String>>
    fun fetchJSendListWithMeta(): Single<JSendSimpleListWithMeta<String, MetaEntity>>
    fun fetchJSendListMeta(): Single<JSendSimpleListWithMeta<String, MetaEntity>>
    fun fetchSimpleJSendListMeta(): Single<JSendSimpleListWithMeta<String, CustomMetaEntity>>
}
