package com.hmju.presentation.mvvm_lifecycle

import com.hmju.presentation.base.BaseViewModel
import com.hmju.presentation.lifecycle.onInit
import com.hmju.presentation.lifecycle.onVisible
import com.til.rxbus.TestBusEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/26
 */
@HiltViewModel
class LifecycleViewModel @Inject constructor() : BaseViewModel() {

    override fun onCreate() {
        super.onCreate()
        +onInit {
            TestBusEvent.listen()
                .subscribe({
                    Timber.d("MSG $it")
                }, {
                    Timber.d("ERROR $it")
                })
        }

        +onVisible {
            TestBusEvent.listen()
                .subscribe({
                    Timber.d("MSG $it")
                }, {
                    Timber.d("ERROR $it")
                })
        }
    }

    fun onTestBusEvent(){
        Timber.d("Click!!!!@!@!@")
        TestBusEvent.publish("Test Hahah ${System.currentTimeMillis()}")
    }
}
