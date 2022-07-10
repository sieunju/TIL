package com.hmju.presentation.refactor_diff_util_v2

import com.hmju.presentation.refactor_diff_util.*

/**
 * Description :
 *
 * Created by juhongmin on 2022/07/10
 */
enum class DiffEnum(
    val areItemsTheSame: (oldItem: Any, newItem: Any) -> Boolean,
    val areContentsTheSame: (oldItem: Any, newItem: Any) -> Boolean
) {
    GOODS_ONE(
        areItemsTheSame = ({ oldItem, newItem ->
            if (oldItem is GoodsOneUiModel && newItem is GoodsOneUiModel) {
                oldItem.item.id == newItem.item.id
            } else {
                false
            }
        }), areContentsTheSame = ({ oldItem, newItem ->
            if (oldItem is GoodsOneUiModel && newItem is GoodsOneUiModel) {
                oldItem.item == newItem.item
            } else {
                false
            }
        })
    ),
    GOODS_TWO(
        areItemsTheSame = ({ oldItem, newItem ->
            if (oldItem is GoodsTwoUiModel && newItem is GoodsTwoUiModel) {
                oldItem.item.id == newItem.item.id
            } else {
                false
            }
        }), areContentsTheSame = ({ oldItem, newItem ->
            if (oldItem is GoodsTwoUiModel && newItem is GoodsTwoUiModel) {
                oldItem.item == newItem.item
            } else {
                false
            }
        })
    )
}