package com.hmju.til

import androidx.multidex.MultiDexApplication
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import java.io.IOException
import java.net.SocketException
import javax.inject.Inject
import javax.inject.Provider

@HiltAndroidApp
class MainApplication : MultiDexApplication() {

    @Inject
    lateinit var viewHolderComponent : Provider<ViewHolderComponent.Builder>

    override fun onCreate() {
        super.onCreate()

        val likeViewHolder = EntryPoints.get(viewHolderComponent,ViewHolderEntryPoint::class.java)
            .likeViewHolder()


        // Rx Exception 처리
        initRxJava()
    }

    /**
     * reactivex.exceptions.UndeliverableException 처리 함수.
     */
    private fun initRxJava() {
        // reactivex.exceptions.UndeliverableException
        // 참고 링크 https://thdev.tech/android/2019/03/04/RxJava2-Error-handling/
        RxJavaPlugins.setErrorHandler { e ->
            var error = e
            if (error is UndeliverableException) {
                error = e.cause
            }
            if (error is IOException || error is SocketException) {
                // fine, irrelevant network problem or API that throws on cancellation
                return@setErrorHandler
            }
            if (error is InterruptedException) {
                // fine, some blocking code was interrupted by a dispose call
                return@setErrorHandler
            }
            if (error is NullPointerException || error is IllegalArgumentException) {
                // that's likely a bug in the application
                Thread.currentThread().uncaughtExceptionHandler?.uncaughtException(
                    Thread.currentThread(),
                    error
                )
                return@setErrorHandler
            }
            if (error is IllegalStateException) {
                // that's a bug in RxJava or in a custom operator
                Thread.currentThread().uncaughtExceptionHandler?.uncaughtException(
                    Thread.currentThread(),
                    error
                )
                return@setErrorHandler
            }
        }
    }
}