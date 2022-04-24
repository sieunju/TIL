package com.hmju.presentation.base

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelLazy
import com.hmju.lifecycle.*
import com.hmju.presentation.BR
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import timber.log.Timber

/**
 * Description : MVVM BaseActivity
 *
 * Created by juhongmin on 2022/03/19
 */
abstract class BaseActivityV2<T : ViewDataBinding, VM : ActivityViewModel>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {

    companion object {
        const val REQ_CODE = "req_code"
        const val RES_CODE = "res_code"
    }

    abstract val viewModel: VM
    lateinit var binding: T

    private var isInit = false

    private val activityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            Timber.d("Activity ResultCode ${it.resultCode}  ${it.data?.extras}")
            viewModel.runCatching {
                val reqCode = it.data?.extras?.getInt(REQ_CODE) ?: -1
                addDisposable(
                    performActivityResult(reqCode, it.resultCode, it.data?.extras)
                )
            }
        }

    private var activityResultDisposable: Disposable? = null

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performBinding()

        viewModel.runCatching {
            onDirectCreate()
            addDisposable(performLifecycle<OnCreated>())
            addDisposable(performLifecycle<OnIntent>())
        }

        with(viewModel) {
            startActivityPage.observe(this@BaseActivityV2) {
                Intent(this@BaseActivityV2, it.targetActivity.java).apply {
                    if (it.flags != -1) {
                        flags = it.flags
                    }
                    putExtras(it.data)

                    startActivity(this)
                }
            }
        }
    }

    @CallSuper
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        viewModel.runCatching {
            val data = intent?.extras
            if (data != null) {
                data.keySet()?.forEach { key ->
                    savedStateHandle.set(key, data.get(key))
                }
                addDisposable(performLifecycle<OnIntent>())
            }
        }
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        viewModel.runCatching {
            onDirectResumed()
            addDisposable(performLifecycle<OnCreatedToResumed>())

            if (isInit) {
                addDisposable(performLifecycle<OnResumed>())
            }
        }
        isInit = true

        // StartActivityResult observer
        performActivityResult()
    }

    @CallSuper
    override fun onStop() {
        super.onStop()
        viewModel.runCatching {
            onDirectStop()
            addDisposable(performLifecycle<OnStopped>())
        }
        // ActivityResult Disposable Observer
        disposableActivityResult()
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        viewModel.clearDisposable()
        isInit = false
    }

    @CallSuper
    override fun finish() {
        with(viewModel) {
            val reqCode = savedStateHandle.get<Int>(REQ_CODE) ?: -1
            val resCode = savedStateHandle.get<Int>(RES_CODE) ?: RESULT_CANCELED
            if (reqCode != -1) {
                val bundle = Bundle()
                bundle.putAll(getBundleData())
                intent.putExtras(bundle)
                setResult(resCode, intent)
            }
        }
        super.finish()
    }

    /**
     * Activity Result 처리 함수
     */
    private fun performActivityResult() {
        activityResultDisposable = RxActivityResultEvent.listen()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val intent = Intent(this, it.targetActivity.java).apply {
                    if (it.flags != -1) {
                        flags = it.flags
                    }
                    it.data.putInt(REQ_CODE, it.requestCode)
                    putExtras(it.data)
                }
                activityResult.launch(intent)
            }, {
                Timber.d("ERROR $it")
            })
    }

    private fun disposableActivityResult() {
        if (activityResultDisposable != null) {
            activityResultDisposable?.dispose()
            activityResultDisposable = null
        }
    }

    /**
     * 기본 viewModels 와 같은 로직의 함수
     */
    protected inline fun <reified VM : ActivityViewModel> initViewModel(): Lazy<VM> {
        return ViewModelLazy(VM::class, { viewModelStore }, { defaultViewModelProviderFactory })
    }

    /**
     * Activity DataBinding 처리 함수
     */
    private fun performBinding() {
        binding = DataBindingUtil.setContentView<T>(this, layoutId).apply {
            lifecycleOwner = this@BaseActivityV2
            setVariable(BR.vm, viewModel)
        }
    }
}
