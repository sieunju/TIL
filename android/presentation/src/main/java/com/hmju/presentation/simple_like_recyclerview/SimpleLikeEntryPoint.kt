package com.hmju.presentation.simple_like_recyclerview

import com.hmju.domain.repository.GoodsRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Description :
 *
 * Created by juhongmin on 2022/01/15
 */
@EntryPoint
@InstallIn(SingletonComponent::class)
interface SimpleLikeEntryPoint {
    fun goodsRepository(): GoodsRepository
}