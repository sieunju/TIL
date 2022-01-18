package com.hmju.presentation.simple_like_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hmju.presentation.BR
import com.hmju.presentation.R
import com.hmju.presentation.databinding.VhSimpleLikeRecyclerview4Binding

class SimpleLike4ViewHolder(
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(R.layout.vh_simple_like_recyclerview_4, parent, false)
) {
    val binding: VhSimpleLikeRecyclerview4Binding by lazy {
        VhSimpleLikeRecyclerview4Binding.bind(
            itemView
        )
    }

    fun onBindView(item: Any) {
        binding.setVariable(BR.item, item)
    }
}