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
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnIntent
import com.hmju.lifecycle.OnResumed
import com.hmju.lifecycle.OnStopped
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
    }

    abstract val viewModel: VM
    lateinit var binding: T

    private var isInit = false

    private val activityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            Timber.d("Activity Result ${it.resultCode}  ${it.data?.extras}")
            viewModel.runCatching {
                addDisposable(performActivityResult(it.resultCode, it.data?.extras))
            }
        }

    private var activityResultDisposable: Disposable? = null

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performBinding()

        viewModel.runCatching {
            addDisposable(performLifecycle<OnCreated>())
            addDisposable(performLifecycle<OnIntent>())
        }
    }

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

    override fun onResume() {
        super.onResume()
        if (isInit) {
            viewModel.runCatching {
                addDisposable(performLifecycle<OnResumed>())
            }
        }
        isInit = true

        // StartActivityResult observer
        performActivityResult()
    }

    override fun onStop() {
        super.onStop()
        viewModel.runCatching {
            addDisposable(performLifecycle<OnStopped>())
        }
        // ActivityResult Disposable Observer
        disposableActivityResult()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clearDisposable()
        isInit = false
    }

    override fun finish() {
        intent.extras?.let { bundle ->
            val reqCode = bundle.getInt(REQ_CODE, -1)
            if (reqCode != -1) {
                bundle.clear()
                Timber.d("Finish ReqCode $reqCode $bundle")
                viewModel.savedStateHandle.remove<Int>(REQ_CODE)
                bundle.putAll(viewModel.getBundleData())
                intent.putExtras(bundle)
                setResult(reqCode, intent)
            }
        }
        super.finish()
    }

    /**
     * Activity Result 처리 함수
     */
    private fun performActivityResult() {
        activityResultDisposable = RxBusActivityResultEvent.listen()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val intent = Intent(this, it.targetActivity.java).apply {
                    if (it.flags != -1) {
                        flags = it.flags
                    }
                    it.data.putInt(REQ_CODE, it.requestCode)
                    putExtras(it.data)
                }
                Timber.d("StartActivityResult ${javaClass.simpleName} ${it.targetActivity.java}")
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
