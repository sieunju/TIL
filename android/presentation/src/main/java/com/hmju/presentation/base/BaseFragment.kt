package com.hmju.presentation.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.hmju.lifecycle.*
import com.hmju.presentation.BR
import timber.log.Timber

/**
 * Description : BaseFragment Class
 *
 * Created by juhongmin on 2022/02/26
 */
abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    companion object {
        val fragmentStackList = mutableListOf<String>()
    }

    abstract val viewModel: VM
    abstract val binding: B

    private var isInit = false

    private val activityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            Timber.d("Fragment Result ${it.resultCode}  ${it.data?.extras}")
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("${javaClass.simpleName} onCreate $isInit")
        viewModel.runCatching {
            addDisposable(performLifecycleRx<OnCreated>())
        }
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = this@BaseFragment
            setVariable(BR.vm, viewModel)
        }
        performLiveData()

        viewModel.runCatching {
            addDisposable(performLifecycleRx<OnViewCreated>())
        }

        // TEST
        fragmentStackList.add(javaClass.simpleName)
    }

    /**
     * BaseFragment 에서 공통으로 처리할 LiveData 을 셋팅하는 함수
     */
    private fun performLiveData() {
        with(viewModel) {
            startActivity.observe(viewLifecycleOwner) { entity ->
                Timber.d("Fragment Activity $entity")
                Intent(requireContext(), entity.target).apply {
                    entity.flags?.let { flags = it }
                    putExtras(entity.bundle)
                    requireContext().startActivity(this)
                }
            }

            startActivityResult.observe(viewLifecycleOwner) { entity ->
                Timber.d("Fragment ActivityResult $entity")
                entity.requestCode?.let { code ->
                    activityResult.launch(
                        Intent(
                            requireContext(),
                            entity.target
                        ).apply {
                            entity.flags?.let { flags = it }
                            entity.bundle.putInt(BaseViewModel.REQ_CODE, code)
                            putExtras(entity.bundle)
                        })
                }
            }

            startPermission.observe(viewLifecycleOwner) { list ->
                runCatching {
                    permissionResult.launch(list.toTypedArray())
                }
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
        Timber.d("${javaClass.simpleName} onStop")
        viewModel.runCatching {
            addDisposable(performLifecycleRx<OnStopped>())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("${javaClass.simpleName} onDestroyView $isInit")
        isInit = false
        viewModel.clearDisposable()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            viewModel.runCatching {
                addDisposable(performLifecycleRx<OnFragmentShown>())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("${javaClass.simpleName} onDestroy")

        // TEST
        fragmentStackList.removeLast()
    }
}
