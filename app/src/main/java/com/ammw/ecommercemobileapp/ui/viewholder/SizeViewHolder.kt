package com.ammw.ecommercemobileapp.ui.viewholder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ammw.ecommercemobileapp.R
import com.ammw.ecommercemobileapp.databinding.ItemSizeBinding
import com.ammw.ecommercemobileapp.ui.adapter.SizeAdapter

class SizeViewHolder(private val binding: ItemSizeBinding, private val mAdapter: SizeAdapter, private val onClickItem: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data:String) {
        binding.tvSize.text = data

        if(mAdapter.mPosition == adapterPosition){
            binding.apply {
                view.visibility = View.VISIBLE
                tvSize.setTextColor(ContextCompat.getColor(itemView.context, R.color.white))
            }
        }else{
            binding.apply {
                view.visibility = View.GONE
                tvSize.setTextColor(ContextCompat.getColor(itemView.context, R.color.colorPrimaryDark))
            }
        }

        binding.root.setOnClickListener {
            mAdapter.mPosition = adapterPosition
            onClickItem(
                adapterPosition
            )
        }
    }
}