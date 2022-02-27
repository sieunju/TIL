package com.til.rxbus

import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * Description : RxBusEvent
 *
 * Created by juhongmin on 2022/02/27
 */

object RxBus {
    private val publisher = PublishSubject.create<Any>()
}

class RxBusEvent {
    data class TestEvent(val id : Long)
}