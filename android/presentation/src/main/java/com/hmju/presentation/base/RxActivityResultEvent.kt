package com.hmju.presentation.base

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import kotlin.reflect.KClass

/**
 * Description : StartActivityResult RxBusEvent Class
 *
 * Created by juhongmin on 2022/04/19
 */
object RxActivityResultEvent {
    private val publisher = PublishSubject.create<ActivityResult>()

    fun publish(data: ActivityResult) {
        publisher.onNext(data)
    }

    fun listen(): Observable<ActivityResult> = publisher
}

data class ActivityResult(
    val requestCode: Int = -1,
    val targetActivity: KClass<out FragmentActivity>,
    val flags: Int = -1,
    val data: Bundle = Bundle()
)