package com.hmju.presentation.refactor_base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnViewCreated
import com.hmju.presentation.base.FragmentViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.kotlin.addTo
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/15
 */
@HiltViewModel
class RefactorBaseRootTestViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : FragmentViewModel() {

    private val _intervalText : MutableLiveData<String> by lazy { MutableLiveData() }
    val intervalText : LiveData<String> get() = _intervalText

    @OnCreated
    fun startInterval(){
        Flowable.interval(1000,TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _intervalText.value = "IntervalText $it"
            },{

            }).addTo(compositeDisposable)
    }
}
