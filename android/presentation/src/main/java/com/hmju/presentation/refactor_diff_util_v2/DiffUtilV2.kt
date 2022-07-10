package com.hmju.presentation.refactor_diff_util_v2

import androidx.recyclerview.widget.DiffUtil
import com.hmju.presentation.refactor_diff_util.BaseUiModel

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

    override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean {
        val oldItem = oldList[oldPos]
        val newItem = newList[newPos]
        return if (oldItem.getClassName() == newItem.getClassName()) {
            oldItem.areItemsTheSame(newItem)
        } else {
            false
        }
    }

    override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean {
        val oldItem = oldList[oldPos]
        val newItem = newList[newPos]
        return if (oldItem.getClassName() == newItem.getClassName()) {
            oldItem.areContentsTheSame(newItem)
        } else {
            false
        }
    }
}