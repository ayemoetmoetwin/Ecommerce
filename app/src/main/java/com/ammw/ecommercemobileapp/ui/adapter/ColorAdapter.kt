package com.ammw.ecommercemobileapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ammw.ecommercemobileapp.databinding.ItemColorBinding
import com.ammw.ecommercemobileapp.ui.viewholder.ColorViewHolder

class ColorAdapter(private val onClickItem: (Int) -> Unit): RecyclerView.Adapter<ColorViewHolder>() {
    private var List = emptyList<String>()
    var mPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val binding = ItemColorBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ColorViewHolder(binding,this, onClickItem = onClickItem)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(
            List[position]
        )
    }

    fun updateList(list: List<String>) {
        List = list
        notifyDataSetChanged()
    }
}