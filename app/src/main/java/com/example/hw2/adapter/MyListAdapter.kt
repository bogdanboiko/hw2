package com.example.hw2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw2.databinding.ItemViewBinding
import com.example.hw2.model.Category

class MyListAdapter : ListAdapter<Category, MyListAdapter.MyViewHolder>(Diff) {
    class MyViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(itemName: String) {
            binding.itemName.text = itemName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindTo(getItem(position).item)
    }

    object Diff : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.item == newItem.item
        }
    }
}
