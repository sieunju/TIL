package com.til.model.params

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/11
 */
open class GoodsParamMap : HashMap<String, Any>() {
    var pageNo: Int = 1
        set(value) {
            put("pageNo", value)
            field = value
        }
    var pageSize: Int = 25
        set(value) {
            put("pageSize", value)
            field = value
        }

    init {
        pageNo = 1
        pageSize = 25
    }
}