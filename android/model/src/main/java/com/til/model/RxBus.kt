package com.til.model

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/15
 */
object RxBus {
    private val publisher = PublishSubject.create<Any>()

    fun publish(event: Any) {
        publisher.onNext(event)
    }

    fun <T> listen(eventType: Class<T>): Observable<T> = publisher.ofType(eventType)
}

class RxBusEvent {
    data class SimpleLikeEvent(
        val isAdd : Boolean,
        val id: Long
    )
}