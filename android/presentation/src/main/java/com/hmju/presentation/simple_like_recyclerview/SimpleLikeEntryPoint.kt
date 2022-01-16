package com.hmju.presentation.simple_like_recyclerview

import com.hmju.domain.repository.GoodsRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface SimpleLikeEntryPoint {
    fun goodsRepository(): GoodsRepository
}