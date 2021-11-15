package com.example.hw2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw2.databinding.ItemViewBinding
import com.example.hw2.fragment.ItemClickListener
import com.example.hw2.model.Category

class MenuAdapter(private val names: List<Category>, val listener : ItemClickListener) :
    RecyclerView.Adapter<MenuAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(category: Category, listener : ItemClickListener) {
            binding.itemName.text = category.item

            binding.root.setOnClickListener {
                listener.onItemClicked(category.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindTo(names[position], listener)
    }

    override fun getItemCount(): Int {
        return names.size
    }
}