package com.hmju.presentation.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.hmju.domain.usecase.GetGoodsUseCase
import com.hmju.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Description : 좀더 Activity or Lifecycle 에 대해서 좀더 간단히 처리하기 위한
 * ViewModel2 클래스
 *
 * Created by juhongmin on 2022/04/13
 */
@HiltViewModel
open class BaseViewModelV2 @Inject constructor() : ViewModel() {

    protected val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    @Inject
    protected lateinit var getGoodsUseCaseT: GetGoodsUseCase

    /**
     * [OnCreated], [OnResumed], [OnStopped], [OnViewCreated]
     * ReactiveX 타입
     * 선언된 함수를 실행 하는 함수
     */
    inline fun <reified T : Annotation> performLifecycle(): Disposable {
        return Flowable.fromIterable(javaClass.methods.toList())
            .filter { it.isAnnotationPresent(T::class.java) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.invoke(this)
            }, {
                Timber.e("PerformLifecycleRx Error $it")
            })
    }

    /**
     * onActivityResult 에 대한 처리
     * ReactiveX 타입
     * @param code RequestCode
     * @param data 전달 받을 데이터
     */
    fun performActivityResult(code: Int, data: Bundle?): Disposable {
        return Flowable.fromIterable(javaClass.methods.toList())
            .filter { it.isAnnotationPresent(OnActivityResult::class.java) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ method ->
                method.getAnnotation(OnActivityResult::class.java)?.let { annotation ->
                    // RequestCode 와 같은 함수만 호출
                    if (annotation.requestCode == code) {
                        method.invoke(this, data)
                    }
                }
            }, {
                Timber.e("performActivityResultRx Error $it")
            })
    }

    /**
     * CompositeDisposable 를 public 으로 처리할수 있는 함수
     * @param disposable Disposable
     */
    fun addDisposable(disposable: Disposable) {
        disposable.addTo(compositeDisposable)
    }

    fun clearDisposable() {
        Timber.d("ClearDisposable ${javaClass.simpleName}")
        compositeDisposable.clear()
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared ${javaClass.simpleName}")
        if (compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}