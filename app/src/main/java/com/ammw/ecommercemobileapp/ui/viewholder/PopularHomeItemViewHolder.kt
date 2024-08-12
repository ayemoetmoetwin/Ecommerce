package com.ammw.ecommercemobileapp.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.ammw.ecommercemobileapp.databinding.ItemPopularHomeBinding
import com.ammw.ecommercemobileapp.domain.model.PopularItemModel
import com.bumptech.glide.Glide

class PopularHomeItemViewHolder(private val binding: ItemPopularHomeBinding, private val onClickItem: (String) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: PopularItemModel) {
        binding.tvName.text = model.name
        binding.tvPrice.text = "$ ${model.price}"
        Glide.with(itemView.context)
            .load(model.imageUrl)
            .into(binding.ivIcon)

        itemView.setOnClickListener {
            model.name?.let { it1 ->
                onClickItem(
                    it1
                )
            }
        }
    }
}