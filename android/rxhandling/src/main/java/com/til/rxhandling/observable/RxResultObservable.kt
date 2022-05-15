package com.til.rxhandling.observable

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.exceptions.CompositeException
import io.reactivex.rxjava3.exceptions.Exceptions
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import retrofit2.Response
import retrofit2.adapter.rxjava3.Result
import timber.log.Timber

/**
 * Description : HTTP 통신 Response Result 로 받는 경우에 대한 Observable
 * Reference: ResultObservable 참고함
 * Created by juhongmin on 2022/05/14
 */
internal class RxResultObservable<T>(
    private val upstream: Observable<Response<T>>
) : Observable<Result<T>>() {
    override fun subscribeActual(observer: Observer<in Result<T>>) {
        upstream.subscribe(ResultObserver(observer))
    }

    internal class ResultObserver<R> constructor(
        private val observer: Observer<in Result<R>>
    ) : Observer<Response<R>> {
        override fun onSubscribe(disposable: Disposable) {
            observer.onSubscribe(disposable)
        }

        override fun onNext(response: Response<R>) {
            observer.onNext(Result.response(response))
        }

        override fun onError(throwable: Throwable) {
            try {
                observer.onNext(Result.error(throwable))
            } catch (t: Throwable) {
                try {
                    observer.onError(t)
                } catch (inner: Throwable) {
                    Exceptions.throwIfFatal(inner)
                    RxJavaPlugins.onError(CompositeException(t, inner))
                }
                return
            }
            observer.onComplete()
        }

        override fun onComplete() {
            observer.onComplete()
        }
    }
}