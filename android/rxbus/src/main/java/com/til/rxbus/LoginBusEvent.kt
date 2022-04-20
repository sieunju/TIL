package com.til.rxbus

import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/27
 */
object LoginBusEvent {
    private val publisher = PublishSubject.create<LoginEvent>()

    fun publish(event: LoginEvent) {
        publisher.onNext(event)
    }

    fun listen() = publisher
}

data class LoginEvent(val isChanged: Boolean, val token: String)