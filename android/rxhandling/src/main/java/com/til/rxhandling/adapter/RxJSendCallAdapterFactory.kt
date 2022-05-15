package com.til.rxhandling.adapter

import com.til.rxhandling.observable.RxBodyObservable
import com.til.rxhandling.observable.RxCallExecuteObservable
import com.til.rxhandling.observable.RxResultObservable
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Response
import retrofit2.Retrofit
import timber.log.Timber
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Description : JSend 및 Error 에 대한 처리를 간단하게 처리 할수 있는 Factory & Adapter Class
 *
 * Created by juhongmin on 2022/05/12
 */
class RxJSendCallAdapterFactory : CallAdapter.Factory() {

    companion object {
        fun create(): CallAdapter.Factory {
            return RxJSendCallAdapterFactory()
        }
    }

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *> {
        val rawType = getRawType(returnType)
        val enumObservableType: ObservableType = ObservableType.findByClass(rawType)
        if (enumObservableType == ObservableType.COMPLETABLE) {
            return JSendCallAdapter<Any>(
                Void::class.java,
                isResult = false,
                isBody = true,
                observableType = enumObservableType
            )
        }
        var isResult = false
        var isBody = false
        val responseType: Type
        if (returnType !is ParameterizedType) {
            val name = enumObservableType.nm
            throw IllegalArgumentException(
                "$name return type must be parameterized as $name <Foo> or $name <? : Foo>"
            )
        }

        val observableType = getParameterUpperBound(0, returnType)
        when (getRawType(observableType)) {
            Response::class.java -> {
                check(observableType is ParameterizedType) { "Response must be parameterized" + " as Response<Foo> or Response<? extends Foo>" }
                responseType = getParameterUpperBound(
                    0,
                    (enumObservableType as ParameterizedType)
                )
            }
            Result::class.java -> {
                check(observableType is ParameterizedType) { "Result must be parameterized" + " as Result<Foo> or Result<? extends Foo>" }
                responseType = getParameterUpperBound(
                    0,
                    (enumObservableType as ParameterizedType)
                )
                isResult = true
            }
            else -> {
                responseType = observableType
                isBody = true
            }
        }
        return JSendCallAdapter<Any>(
            responseType = responseType,
            isResult = isResult,
            isBody = isBody,
            observableType = enumObservableType
        )
    }

    class JSendCallAdapter<R : Any>(
        private val responseType: Type,
        private val isResult: Boolean = false,
        private val isBody: Boolean = false,
        private val observableType: ObservableType
    ) : CallAdapter<R, Any> {

        override fun responseType(): Type {
            return responseType
        }

        override fun adapt(call: Call<R>): Any {
            val responseObservable : Observable<Response<R>> = RxCallExecuteObservable(call)
            Timber.d("Observable ${observableType.nm} isResult $isResult isBody $isBody")
            var observable: Observable<*> = if(isResult) {
                RxResultObservable(responseObservable)
            } else if(isBody) {
                RxBodyObservable(responseObservable)
            } else {
                responseObservable
            }

            observable = observable.subscribeOn(Schedulers.io())

            return when (observableType) {
                ObservableType.SINGLE -> {
                    observable.singleOrError()
                }
                ObservableType.COMPLETABLE -> {
                    observable.ignoreElements()
                }
                ObservableType.MAYBE -> {
                    observable.singleElement()
                }
                ObservableType.FLOWABLE -> {
                    observable.toFlowable(BackpressureStrategy.LATEST)
                }
                ObservableType.OBSERVABLE -> {
                    RxJavaPlugins.onAssembly(observable)
                }
            }
        }
    }

    enum class ObservableType(private val clazz: Class<*>, val nm: String) {
        FLOWABLE(Flowable::class.java, "Flowable"),
        SINGLE(Single::class.java, "Single"),
        MAYBE(Maybe::class.java, "Maybe"),
        COMPLETABLE(Completable::class.java, "Completable"),
        OBSERVABLE(Observable::class.java, "Observable");

        companion object {
            fun findByClass(clazz: Class<*>): ObservableType {
                values()
                    .filter { it.clazz == clazz }
                    .forEach { return it }
                throw IllegalArgumentException("no such type : " + clazz.canonicalName)
            }
        }
    }

}