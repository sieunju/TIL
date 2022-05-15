package com.til.rxhandling.observable

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.exceptions.CompositeException
import io.reactivex.rxjava3.exceptions.Exceptions
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber

/**
 * Description : HTTP 통신 Response Body 로 받는 경우에 대한 Observable
 * Reference: BodyObservable 참고함
 * Created by juhongmin on 2022/05/14
 */
internal class RxBodyObservable<T : Any>(
    private val upstream: Observable<Response<T>>
) : Observable<T>() {

    override fun subscribeActual(observer: Observer<in T>) {
        upstream.subscribe(BodyObserver(observer))
    }

    private class BodyObserver<R : Any> constructor(
        private val observer: Observer<in R>
    ) : Observer<Response<R>> {
        private var terminated = false

        override fun onSubscribe(disposable: Disposable) {
            observer.onSubscribe(disposable)
        }

        override fun onNext(response: Response<R>) {
            if (response.isSuccessful) {
                Timber.d("onNext Success ${response.body().toString()}")
                val body = response.body()
                if (body != null) {
                    observer.onNext(body)
                } else {
                    observer.onError(NullPointerException("Body is Null"))
                }
            } else {
                Timber.d("onNext Error $response")
                terminated = true
                val t: Throwable = HttpException(response)
                try {
                    observer.onError(t)
                } catch (inner: Throwable) {
                    Exceptions.throwIfFatal(inner)
                    RxJavaPlugins.onError(CompositeException(t, inner))
                }
            }
        }

        override fun onComplete() {
            if (!terminated) {
                observer.onComplete()
            }
        }

        override fun onError(throwable: Throwable) {
            Timber.d("Error?? $throwable")
            if (!terminated) {
                observer.onError(throwable)
            } else {
                // This should never happen! onNext handles and forwards errors automatically.
                val broken: Throwable = AssertionError(
                    "This should never happen! Report as a bug with the full stacktrace."
                )
                broken.initCause(throwable)
                RxJavaPlugins.onError(broken)
            }
        }
    }
}
