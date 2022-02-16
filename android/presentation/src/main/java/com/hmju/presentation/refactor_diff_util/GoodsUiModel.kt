package com.hmju.presentation.refactor_diff_util

import com.hmju.presentation.R
import com.til.model.goods.GoodsEntity

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/16
 */
data class GoodsOneUiModel(
    val item: GoodsEntity
) : BaseUiModel(R.layout.vh_simple_like_recyclerview_1)

data class GoodsTwoUiModel(
    val item: GoodsEntity
) : BaseUiModel(R.layout.vh_simple_like_recyclerview_1)