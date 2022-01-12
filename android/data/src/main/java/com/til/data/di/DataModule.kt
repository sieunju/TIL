package com.til.data.di

import com.til.data.impl.AuthRepositoryImpl
import com.til.data.impl.GoodsRepositoryImpl
import com.til.domain.repository.AuthRepository
import com.til.domain.repository.GoodsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Description : Data Module Class
 *
 * Created by juhongmin on 2022/01/12
 */
@InstallIn(SingletonComponent::class)
@Module(includes = [RemoteModule::class])
internal abstract class DataModule {
    @Singleton
    @Binds
    abstract fun bindGoodsRepository(repository: GoodsRepositoryImpl): GoodsRepository

    @Singleton
    @Binds
    abstract fun bindAuthRepository(repository: AuthRepositoryImpl): AuthRepository
}