package com.til.tracking.entity

/**
 * Description : Base Tracking Entity
 *
 * Created by juhongmin on 2022/03/30
 */
open class BaseTrackingEntity {
    var takenTimeMs: Long = 0L // 걸린 시간
    var code : Int = 0
    var baseUrl: String = "" // domain url
    var method: String = "" // POST, GET, PUT
    var error : Exception? = null

    override fun toString(): String {
        return "Domain=${baseUrl} Method=$method\nResponseCode=${code}\nTime=${takenTimeMs}MS\nError=$error"
    }
}