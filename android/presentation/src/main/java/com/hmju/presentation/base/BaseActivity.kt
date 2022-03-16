package com.hmju.presentation.base

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.hmju.lifecycle.OnCreated
import com.hmju.lifecycle.OnResumed
import com.hmju.lifecycle.OnStopped
import com.hmju.presentation.BR
import timber.log.Timber

/**
 * Description : DataBinding 이 없는 ViewModel 기반의 Activity
 *
 * Created by juhongmin on 2022/02/26
 */
abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {

    abstract val viewModel: VM
    lateinit var binding: B

    private var isInit = false

    private val activityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            Timber.d("Activity Result ${it.resultCode}  ${it.data?.extras}")
            runCatching {
                viewModel.performActivityResultRx(it.resultCode, it.data?.extras)
            }
        }

    private val permissionResult =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            Timber.d("Permission Result $it")
            runCatching {
                viewModel.performPermissionResultRx(it)
            }
        }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<B>(this, layoutId).apply {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.vm, viewModel)
        }
        performLiveData()
        Timber.d("${javaClass.simpleName} onCreate $isInit")
        viewModel.runCatching {
            addDisposable(performLifecycleRx<OnCreated>())
        }
    }

    /**
     * BaseActivity 에서 공통으로 처리할 LiveData 을 셋팅하는 함수
     */
    private fun performLiveData() {
        with(viewModel) {
            startActivity.observe(this@BaseActivity) { entity ->
                Timber.d("Activity $entity")
                Intent(this@BaseActivity, entity.target).apply {
                    entity.flags?.let { flags = it }
                    putExtras(entity.bundle)
                    this@BaseActivity.startActivity(this)
                }
            }

            startActivityResult.observe(this@BaseActivity) { entity ->
                Timber.d("ActivityResult $entity")
                entity.requestCode?.let { code ->
                    activityResult.launch(
                        Intent(
                            this@BaseActivity,
                            entity.target
                        ).apply {
                            entity.flags?.let { flags = it }
                            entity.bundle.putInt(BaseViewModel.REQ_CODE, code)
                            putExtras(entity.bundle)
                        })
                }
            }

            startPermission.observe(this@BaseActivity) { list ->
                permissionResult.launch(list.toTypedArray())
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Timber.d("${javaClass.simpleName} onResume $isInit")
        if (isInit) {
            viewModel.runCatching {
                addDisposable(performLifecycleRx<OnResumed>())
            }
        }
        isInit = true
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop")
        viewModel.runCatching {
            addDisposable(performLifecycleRx<OnStopped>())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("${javaClass.simpleName} onDestroy $isInit")
        viewModel.clearDisposable()
        isInit = false
    }

    override fun finish() {
        intent.extras?.let { bundle ->
            val reqCode = bundle.getInt(BaseViewModel.REQ_CODE, -1)
            Timber.d("Finish ReqCode $reqCode $bundle")
            if (reqCode != -1) {
                setResult(reqCode, intent)
            }
        }
        super.finish()
    }
}
