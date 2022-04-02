package com.til.tracking.rx

import com.til.tracking.entity.TrackingHttpEntity
import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * Description : 선택한 API 정보를 자세히 보기로 넘기는 RxBus 이벤트
 *
 * Created by juhongmin on 2022/04/02
 */
object TrackingDetailEvent {
    private val publisher = PublishSubject.create<TrackingHttpEntity>()

    fun publish(entity: TrackingHttpEntity) {
        publisher.onNext(entity)
    }

    fun listen(): PublishSubject<TrackingHttpEntity> = publisher
}
