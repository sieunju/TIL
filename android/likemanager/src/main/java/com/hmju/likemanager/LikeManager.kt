package com.hmju.likemanager

import java.util.concurrent.ConcurrentHashMap

/**
 * Description : 좋아요한 아이템들 관리하는 클래스
 *
 * Created by juhongmin on 2022/01/15
 */
object LikeManager {
    private val likeSet: ConcurrentHashMap<Long, Boolean> by lazy {
        ConcurrentHashMap()
    }

    fun addLike(id: Long) {
        likeSet[id] = true
    }

    fun removeLike(id: Long) {
        likeSet.remove(id)
    }

    fun isLike(id: Long): Boolean {
        return likeSet.containsKey(id)
    }
}
