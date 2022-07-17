package com.hmju.proxy.di

import com.hmju.proxy.ActivityProvider
import com.hmju.proxy.impl.ActivityProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Description : 프록시 모듈
 *
 * Created by juhongmin on 2022/07/13
 */
@InstallIn(SingletonComponent::class)
@Module
internal abstract class ProxyModule {
    @Singleton
    @Binds
    abstract fun bindActivityProvider(provider: ActivityProviderImpl): ActivityProvider
}
