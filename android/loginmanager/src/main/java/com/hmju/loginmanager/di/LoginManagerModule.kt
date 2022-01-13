package com.hmju.loginmanager.di

import com.hmju.loginmanager.LoginManager
import com.hmju.loginmanager.impl.LoginManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Description : 로그인 메니저 모듈
 *
 * Created by juhongmin on 2022/01/12
 */
@InstallIn(SingletonComponent::class)
@Module
internal abstract class LoginManagerModule {
    @Singleton
    @Binds
    abstract fun bindLoginManager(loginManager: LoginManagerImpl): LoginManager
}