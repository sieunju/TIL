package com.features.network.di

import com.features.network.impl.NetworkRequirementsImpl
import com.features.network_requirements.NetworkRequirements
import dagger.Binds
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Description : Network-UI Module
 *
 * Created by juhongmin on 2022/07/22
 */
@InstallIn(SingletonComponent::class)
internal abstract class FeatureModule {
    @Singleton
    @Binds
    abstract fun bindNetworkRequirements(requirements: NetworkRequirementsImpl): NetworkRequirements
}
