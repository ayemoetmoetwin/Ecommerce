package com.ammw.ecommercemobileapp.ui.viewholder

import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ammw.ecommercemobileapp.R
import com.ammw.ecommercemobileapp.databinding.ItemBrandBinding
import com.ammw.ecommercemobileapp.domain.model.BrandModel
import com.ammw.ecommercemobileapp.ui.adapter.BrandAdapter
import com.bumptech.glide.Glide
import okhttp3.internal.wait

class BrandViewHolder(private val binding: ItemBrandBinding,private val mAdapter: BrandAdapter,private val onClickItem: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: BrandModel) {
        Glide.with(itemView.context)
            .load(model.imageUrl)
            .into(binding.ivIcon)

        if(mAdapter.mPosition == model.id){
            binding.apply {
                view.visibility = View.GONE
            }
        }else{
            binding.apply {
                view.visibility = View.VISIBLE
            }
        }

        binding.root.setOnClickListener {
            Log.d("test_data","data is ${model.id}")
            mAdapter.mPosition = model.id
            onClickItem(
                model.id
            )
        }
    }
}