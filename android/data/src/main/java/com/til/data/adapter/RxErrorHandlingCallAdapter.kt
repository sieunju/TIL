package com.til.data.adapter

import com.til.model.base.*
import com.til.model.error.JSendEmptyDataException
import com.til.model.error.JSendInvalidPayloadException
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import timber.log.Timber
import java.lang.reflect.Type

/**
 * Description : RxError Handling Adapter
 *
 * Created by juhongmin on 2022/06/18
 */
class RxErrorHandlingCallAdapter : CallAdapter.Factory() {
    private val original = RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io())

    companion object {
        fun create(): CallAdapter.Factory {
            return RxErrorHandlingCallAdapter()
        }
    }

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        val adapter = original.get(returnType, annotations, retrofit)
        return if (adapter != null) {
            RxJavaCallAdapterWrapper(adapter)
        } else {
            null
        }
    }

    class RxJavaCallAdapterWrapper<R>(
        private val original: CallAdapter<R, *>
    ) : CallAdapter<R, Any> {

        override fun responseType(): Type = original.responseType()

        override fun adapt(call: Call<R>): Any {
            return when (val res = original.adapt(call)) {
                is Single<*> -> {
                    res.map { it.performErrorHandling() }
                }
                is Flowable<*> -> {
                    res.map { it.performErrorHandling() }
                }
                else -> {
                    throw IllegalArgumentException("Not Invalid Type")
                }
            }
        }

        @Throws(JSendInvalidPayloadException::class, JSendEmptyDataException::class)
        private fun Any.performErrorHandling(): Any {
            return if (checkDataPayload()) {
                this
            } else {
                if(this is BaseJSend) {
                    throw JSendInvalidPayloadException(message)
                } else {
                    throw JSendInvalidPayloadException("Invalid Exception")
                }
            }
        }

        /**
         * data 가 없거나 안에 payload 가 유효하지 않는 경우
         */
        @Throws(JSendEmptyDataException::class)
        private fun Any.checkDataPayload(): Boolean {
            return when (this) {
                is JSendObj<*> -> {
                    return if (this.isValid) {
                        true
                    } else {
                        if (isSuccess) {
                            throw JSendEmptyDataException(message)
                        } else {
                            false
                        }
                    }
                }
                is JSendObjWithMeta<*, *> -> {
                    return if (this.isValid) {
                        true
                    } else {
                        if (isSuccess) {
                            throw JSendEmptyDataException(message)
                        } else {
                            false
                        }
                    }
                }
                is JSendList<*> -> {
                    return if (this.isValid) {
                        true
                    } else {
                        if (isSuccess) {
                            throw JSendEmptyDataException(message)
                        } else {
                            false
                        }
                    }
                }
                is JSendListWithMeta<*, *> -> {
                    return if (this.isValid) {
                        true
                    } else {
                        if (isSuccess) {
                            throw JSendEmptyDataException(message)
                        } else {
                            false
                        }
                    }
                }
                // 규격화된 방식이 아닌경우 true 리턴
                else -> true
            }
        }
    }
}