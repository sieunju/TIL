package com.hmju.domain.usecase

import com.hmju.domain.repository.GoodsRepository
import com.hmju.likemanager.LikeManager
import com.til.model.RxBus
import com.til.model.RxBusEvent
import com.til.model.body.LikeRequestBody
import com.til.model.like.LikeEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Description : 좋아요 추가 처리하는 UseCase
 *
 * Created by juhongmin on 2022/01/14
 */
class AddLikeUseCase @Inject constructor(
    private val repository: GoodsRepository
) {
    operator fun invoke(body: LikeRequestBody): Single<LikeEntity> {
        return repository.postLike(body)
            .map { it.obj ?: throw NullPointerException("Data is Null") }
            .map {
                LikeManager.addLike(body.id)
                RxBus.publish(RxBusEvent.SimpleLikeEvent(true,body.id))
                return@map it
            }
    }
}