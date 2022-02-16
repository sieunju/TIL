package com.hmju.presentation.simple_like_recyclerview

import android.view.ViewGroup
import com.hmju.presentation.BR
import com.hmju.presentation.R
import com.hmju.presentation.base.BaseSimpleLikeViewHolder
import com.hmju.presentation.databinding.VhSimpleLikeRecyclerview1Binding
import com.hmju.presentation.refactor_diff_util.GoodsOneUiModel

/**
 * Description : 간단한 좋아요 아이템 샘플 1
 *
 * Created by juhongmin on 2022/01/15
 */
class SimpleLike1ViewHolder(
    parent: ViewGroup
) : BaseSimpleLikeViewHolder<VhSimpleLikeRecyclerview1Binding>(
    parent,
    R.layout.vh_simple_like_recyclerview_1
) {

    init {
        binding.imgLike.setOnClickListener {
            simpleLikeClick(it, binding.item)
        }
    }

    override fun onBindView(item: Any) {
        if (item is GoodsOneUiModel) {
            binding.setVariable(BR.item, item.item)
        } else {
            binding.setVariable(BR.item, item)
        }
    }

    override fun onRefreshLike() {
        simpleLikeChange(binding.imgLike, binding.item)
    }
}
