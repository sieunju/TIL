package com.hmju.presentation.mvvm_lifecycle

import com.hmju.loginmanager.LoginManager
import com.hmju.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2022/03/11
 */
@HiltViewModel
class MvvmLifecycleTestViewModel2 @Inject constructor(
    private val loginManager : LoginManager
) : BaseViewModel() {

}
