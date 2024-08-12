package com.ammw.ecommercemobileapp.ui.viewholder

import android.graphics.Color
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ammw.ecommercemobileapp.R
import com.ammw.ecommercemobileapp.databinding.ItemColorBinding
import com.ammw.ecommercemobileapp.ui.adapter.ColorAdapter

class ColorViewHolder(private val binding: ItemColorBinding, private val mAdapter: ColorAdapter, private val onClickItem: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: String) {
        binding.mcv.setCardBackgroundColor(
            Color.parseColor(data)
        )
        if(mAdapter.mPosition == adapterPosition){
            binding.apply {
                ivIcon.visibility = View.VISIBLE
            }
        }else{
            binding.apply {
                ivIcon.visibility = View.GONE
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