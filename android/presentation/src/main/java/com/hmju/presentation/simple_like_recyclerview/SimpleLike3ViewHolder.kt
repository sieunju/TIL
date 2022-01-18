package com.hmju.presentation.simple_like_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hmju.presentation.BR
import com.hmju.presentation.R
import com.hmju.presentation.databinding.VhSimpleLikeRecyclerview3Binding

class SimpleLike3ViewHolder(
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(R.layout.vh_simple_like_recyclerview_3, parent, false)
) {
    val binding: VhSimpleLikeRecyclerview3Binding by lazy {
        VhSimpleLikeRecyclerview3Binding.bind(
            itemView
        )
    }

    fun onBindView(item: Any) {
        binding.setVariable(BR.item, item)
    }
}