package com.ammw.ecommercemobileapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ammw.ecommercemobileapp.databinding.ItemPopularHomeBinding
import com.ammw.ecommercemobileapp.domain.model.PopularItemModel
import com.ammw.ecommercemobileapp.ui.viewholder.PopularHomeItemViewHolder

class PopularHomeItemAdapter(private val onClickItem: (String) -> Unit): RecyclerView.Adapter<PopularHomeItemViewHolder>() {
    private var List = emptyList<PopularItemModel>()
    var mPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularHomeItemViewHolder {
        val binding = ItemPopularHomeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PopularHomeItemViewHolder(binding,onClickItem)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: PopularHomeItemViewHolder, position: Int) {
        holder.bind(
            List[position]
        )
    }

    fun updateList(list: List<PopularItemModel>) {
        List = list
        notifyDataSetChanged()
    }
}