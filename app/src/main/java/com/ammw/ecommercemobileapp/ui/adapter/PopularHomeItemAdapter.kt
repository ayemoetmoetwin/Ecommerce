package com.ammw.ecommercemobileapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ammw.ecommercemobileapp.databinding.ItemPopularBinding
import com.ammw.ecommercemobileapp.domain.model.PopularItemModel
import com.ammw.ecommercemobileapp.ui.viewholder.PopularItemViewHolder

class PopularItemAdapter(private val onClickItem: (String) -> Unit): RecyclerView.Adapter<PopularItemViewHolder>() {
    private var List = emptyList<PopularItemModel>()
    var mPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularItemViewHolder {
        val binding = ItemPopularBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PopularItemViewHolder(binding,onClickItem)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: PopularItemViewHolder, position: Int) {
        holder.bind(
            List[position]
        )
    }

    fun updateList(list: List<PopularItemModel>) {
        List = list
        notifyDataSetChanged()
    }
}