package com.hmju.presentation.simple_like_recyclerview

import android.view.ViewGroup
import com.hmju.presentation.BR
import com.hmju.presentation.R
import com.hmju.presentation.databinding.VhSimpleLikeRecyclerview2Binding

/**
 * Description : 간단한 좋아요 아이템 샘플 1
 *
 * Created by juhongmin on 2022/01/15
 */
class SimpleLike2ViewHolder(
    parent: ViewGroup
) : BaseSimpleLikeViewHolder<VhSimpleLikeRecyclerview2Binding>(
    parent,
    R.layout.vh_simple_like_recyclerview_2
) {

    init {
        binding.imgLike.setOnClickListener {
            simpleLikeChange(it, binding.item)
        }
    }

    override fun onBindView(item: Any) {
        binding.setVariable(BR.item, item)
    }

    override fun onRefreshLike() {
        simpleLikeChange(binding.imgLike, binding.item)
    }
}