package com.hmju.presentation.refactor_base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hmju.lifecycle.OnResumed
import com.hmju.lifecycle.OnViewCreated
import com.hmju.presentation.base.FragmentViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.kotlin.addTo
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/15
 */
@HiltViewModel
class RefactorTestFragmentViewModel @Inject constructor(

) : FragmentViewModel() {

    private val _title : MutableLiveData<String> by lazy { MutableLiveData() }
    val title : LiveData<String> get() = _title

    @OnViewCreated
    fun start(){
        _title.value = "안녕하세요"
    }

    @OnResumed
    fun changeTitle(){
        Single.just("변경했습니다.")
            .delay(3000,TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Timber.d("왔슴다!! $it")
                _title.value = it
            },{
                Timber.d("ERROR $it")
            }).addTo(compositeDisposable)
    }
}
