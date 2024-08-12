package com.ammw.ecommercemobileapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ammw.ecommercemobileapp.databinding.ItemBrandBinding
import com.ammw.ecommercemobileapp.domain.model.BrandModel
import com.ammw.ecommercemobileapp.ui.viewholder.BrandViewHolder

class BrandAdapter(private val onClickItem: (Int,String) -> Unit): RecyclerView.Adapter<BrandViewHolder>() {
    private var List = emptyList<BrandModel>()
    var mPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val binding = ItemBrandBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BrandViewHolder(binding,this,onClickItem)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        holder.bind(
            List[position]
        )
    }

    fun updateList(list: List<BrandModel>) {
        List = list
        notifyDataSetChanged()
    }
}