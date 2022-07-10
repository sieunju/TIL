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
) : BaseUiModel(R.layout.vh_simple_like_recyclerview_1) {

    override fun getClassName() = "GoodsOneUiModel"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is GoodsOneUiModel) {
            item.id == diffItem.item.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if(diffItem is GoodsOneUiModel) {
            item == diffItem.item
        } else {
            false
        }
    }
}

data class GoodsTwoUiModel(
    val item: GoodsEntity
) : BaseUiModel(R.layout.vh_simple_like_recyclerview_2) {

    override fun getClassName() = "GoodsTwoUiModel"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is GoodsTwoUiModel) {
            item.id == diffItem.item.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if(diffItem is GoodsTwoUiModel) {
            item == diffItem.item
        } else {
            false
        }
    }
}