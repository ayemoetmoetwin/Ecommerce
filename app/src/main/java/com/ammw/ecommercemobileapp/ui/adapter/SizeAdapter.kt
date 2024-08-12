package com.ammw.ecommercemobileapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ammw.ecommercemobileapp.databinding.ItemSizeBinding
import com.ammw.ecommercemobileapp.ui.viewholder.SizeViewHolder

class SizeAdapter(private val onClickItem: (Int) -> Unit): RecyclerView.Adapter<SizeViewHolder>() {
    private var List = emptyList<String>()
    var mPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeViewHolder {
        val binding = ItemSizeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SizeViewHolder(binding,this,onClickItem)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: SizeViewHolder, position: Int) {
        holder.bind(
            List[position]
        )
    }

    fun updateList(list: List<String>) {
        List = list
        notifyDataSetChanged()
    }
}