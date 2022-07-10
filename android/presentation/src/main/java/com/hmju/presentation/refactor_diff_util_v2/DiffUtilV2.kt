package com.hmju.presentation.refactor_diff_util_v2

import androidx.recyclerview.widget.DiffUtil
import com.hmju.presentation.refactor_diff_util.BaseUiModel
import com.hmju.presentation.refactor_diff_util.GoodsOneUiModel
import com.hmju.presentation.refactor_diff_util.GoodsTwoUiModel
import timber.log.Timber
import java.util.concurrent.ConcurrentHashMap

/**
 * Description :
 *
 * Created by juhongmin on 2022/06/26
 */
class DiffUtilV2(
    private val oldList: List<BaseUiModel>,
    private val newList: List<BaseUiModel>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize(): Int = newList.size

    companion object {
        val diffEnumMap: ConcurrentHashMap<String, DiffEnum> = ConcurrentHashMap()
    }

    override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean {
        val oldItem = oldList[oldPos]
        val newItem = newList[newPos]
        // Enum 방식
        /*putDiffMap(oldItem, newItem)
        val diffEnum = diffEnumMap[oldItem.getClassName()]
        return diffEnum?.areItemsTheSame?.invoke(oldItem, newItem) ?: false*/

        // BaseUiModel abstract 방식
        return if (oldItem.getClassName() == newItem.getClassName()) {
            oldItem.areItemsTheSame(newItem)
        } else {
            false
        }
    }

    override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean {
        val oldItem = oldList[oldPos]
        val newItem = newList[newPos]
        // Enum 방식
        /*putDiffMap(oldItem, newItem)
        val diffEnum = diffEnumMap[oldItem.getClassName()]
        return diffEnum?.areContentsTheSame?.invoke(oldItem, newItem) ?: false*/

        // BaseUiModel abstract 방식
        return if (oldItem.getClassName() == newItem.getClassName()) {
            oldItem.areContentsTheSame(newItem)
        } else {
            false
        }
    }

    private fun putDiffMap(oldItem: BaseUiModel, newItem: BaseUiModel) {
        if (!diffEnumMap.containsKey(oldItem.getClassName())) {
            if (oldItem is GoodsOneUiModel) {
                diffEnumMap["GoodsOneUiModel"] = DiffEnum.GOODS_ONE
            } else if (oldItem is GoodsTwoUiModel) {
                diffEnumMap["GoodsTwoUiModel"] = DiffEnum.GOODS_TWO
            }
        }

        if (!diffEnumMap.containsKey(newItem.getClassName())) {
            if (newItem is GoodsOneUiModel) {
                diffEnumMap["GoodsOneUiModel"] = DiffEnum.GOODS_ONE
            } else if (newItem is GoodsTwoUiModel) {
                diffEnumMap["GoodsTwoUiModel"] = DiffEnum.GOODS_TWO
            }
        }
    }
}