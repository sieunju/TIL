package com.hmju.loginmanager.di

import com.hmju.loginmanager.LoginManager
import com.hmju.loginmanager.impl.LoginManagerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/12
 */
@Module
abstract class LoginManagerModule {
    @Singleton
    @Binds
    abstract fun bindLoginManager(loginManager: LoginManagerImpl) : LoginManager
}