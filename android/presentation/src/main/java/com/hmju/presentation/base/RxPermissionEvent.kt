package com.hmju.presentation.base

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * Description : StartPermissionResult RxBusEvent Class
 *
 * Created by juhongmin on 2022/04/24
 */
object RxPermissionEvent {
    private val publisher = PublishSubject.create<List<String>>()

    fun publish(data: List<String>) {
        publisher.onNext(data)
    }

    fun listen(): Observable<List<String>> = publisher
}
