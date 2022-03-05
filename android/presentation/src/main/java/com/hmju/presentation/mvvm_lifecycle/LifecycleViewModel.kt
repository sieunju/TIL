package com.hmju.presentation.mvvm_lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hmju.loginmanager.LoginManager
import com.hmju.presentation.base.BaseViewModel
import com.hmju.presentation.lifecycle.onInit
import com.hmju.presentation.lifecycle.onVisible
import com.til.rxbus.LoginBusEvent
import com.til.rxbus.TestBusEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/26
 */
@HiltViewModel
class LifecycleViewModel @Inject constructor(
    private val loginManager: LoginManager
) : BaseViewModel() {

    val moveFragment: MutableLiveData<Unit> by lazy { MutableLiveData() }
    val moveActivity : MutableLiveData<Unit> by lazy { MutableLiveData() }

    private val _text: MutableLiveData<String> by lazy { MutableLiveData() }
    val text: LiveData<String> get() = _text

    override fun onCreate() {
        super.onCreate()
        _text.value = "Hello"
//        +onInit {
//            TestBusEvent.listen()
//                .subscribe({
//                    Timber.d("Init MSG $it")
//                }, {
//                    Timber.d("ERROR $it")
//                })
//        }

        +onInit {
            LoginBusEvent.listen()
                .doOnNext {
                    Timber.d("onCreate $it")
                    _text.postValue(it.token)
                }
                .subscribe()
        }

//        +onVisible {
//            TestBusEvent.listen()
//                .subscribe({
//                    Timber.d("onVisible MSG $it")
//                }, {
//                    Timber.d("ERROR $it")
//                })
//        }

        +onVisible {
            LoginBusEvent.listen()
                .doOnNext {
                    Timber.d("onResume $it")
                }
                .subscribe()
        }

        +onVisible {
            loginManager.rxIsLogin()
                .subscribeOn(Schedulers.computation())
                .subscribe({
                    Timber.d("Is Login $it")
                }, {

                })
        }
    }

    fun onTestBusEvent() {
        TestBusEvent.publish("Test Hahah ${System.currentTimeMillis()}")
    }

    fun moveFragment() {
        moveFragment.value = Unit
    }

    fun moveActivity(){
        moveActivity.value = Unit
    }
}
