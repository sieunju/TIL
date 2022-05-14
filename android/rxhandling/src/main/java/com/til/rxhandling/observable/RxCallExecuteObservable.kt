package com.til.rxhandling.observable

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.exceptions.CompositeException
import io.reactivex.rxjava3.exceptions.Exceptions
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import retrofit2.Call
import retrofit2.Response
import retrofit2.adapter.rxjava3.HttpException
import timber.log.Timber

/**
 * Description : JSend 규칙에 따라서 처리하는 Observable
 *
 * Created by juhongmin on 2022/05/14
 */
class RxCallExecuteObservable<T>(
    private val originalCall: Call<T>
) : Observable<Response<T>>() {

    override fun subscribeActual(observer: Observer<in Response<T>>) {
        val call = originalCall.clone()
        val disposable = CallDisposable(call)
        observer.onSubscribe(disposable)
        if (disposable.isDisposed) {
            return
        }
        var terminated = false
        try {
            val response = call.execute()
            Timber.d("Response $response")
            if (!disposable.isDisposed) {
                observer.onNext(response)
            }
            if (!disposable.isDisposed) {
                terminated = true
                observer.onComplete()
            }
        } catch (t: Throwable) {
            Exceptions.throwIfFatal(t)
            if (terminated) {
                RxJavaPlugins.onError(t)
            } else if (!disposable.isDisposed) {
                try {
                    observer.onError(t)
                } catch (inner: Throwable) {
                    Exceptions.throwIfFatal(inner)
                    RxJavaPlugins.onError(CompositeException(t, inner))
                }
            }
        }
    }

    private class CallDisposable(private val call: Call<*>) : Disposable {
        @Volatile
        private var disposed = false
        override fun dispose() {
            disposed = true
            call.cancel()
        }

        override fun isDisposed(): Boolean {
            return disposed
        }
    }

    companion object {
        private class BodyObserver<R : Any> internal constructor(
            private val observer: Observer<in R>
        ) : Observer<Response<R>> {
            private var terminated = false
            override fun onSubscribe(disposable: Disposable) {
                observer.onSubscribe(disposable)
            }

            override fun onNext(response: Response<R>) {
                if (response.isSuccessful) {
                    observer.onNext(response.body())
                } else {
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
}