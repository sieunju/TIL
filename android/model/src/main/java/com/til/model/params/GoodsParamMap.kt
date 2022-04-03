package com.til.model.params

import java.net.URLEncoder
import java.util.concurrent.ConcurrentHashMap

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/11
 */
open class GoodsParamMap : ConcurrentHashMap<String, Any>() {
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
    var tempQueryList: List<String>? = null
        set(value) {
            remove("tempList")
            if (!value.isNullOrEmpty()) {
                put("tempList", value)
            }
            field = value
        }
    var tempQueryString: List<String>? = null
        set(value) {
            remove("tempStr")
            if (!value.isNullOrEmpty()) {
                val list = mutableListOf<String>()
                value.forEach { str ->
                    list.add(URLEncoder.encode(str, Charsets.UTF_8.name()))
                }
                put("tempStr", list.joinToString(","))
            }
            field = value
        }

    init {
        pageNo = 1
        pageSize = 25
    }
}