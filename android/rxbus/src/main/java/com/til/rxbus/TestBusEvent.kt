package com.til.rxbus

import io.reactivex.rxjava3.kotlin.ofType
import io.reactivex.rxjava3.processors.PublishProcessor
import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * Description : PublishSubject 구독 이후 가장 최신값을 받기 위한 Event
 *
 * Created by juhongmin on 2022/02/27
 */
object TestBusEvent {
    private val publisher = PublishSubject.create<String>()

    fun publish(msg : String) {
        publisher.onNext(msg)
    }

    fun listen() = publisher.ofType<String>()
}