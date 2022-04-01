package com.til.tracking.rx

import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/01
 */
object TrackingNotifyChangeEvent {
    private val publisher = PublishSubject.create<Long>()

    fun publish(cnt : Long) {
        publisher.onNext(cnt)
    }

    fun listen() = publisher
}