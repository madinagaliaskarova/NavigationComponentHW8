package com.geektech.navigationcomponenthw8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.navigationcomponenthw8.databinding.ItemBinding

class Adapter(private val data: ArrayList<Model>,private val mListener: OnClickItem) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(ItemBinding.bind(itemView))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: Model) {
            model.imageView?.let { binding.image.setImageResource(it) }
            binding.firstText.text = model.txt_first
            binding.secondText.text = model.txt_second

            itemView.setOnClickListener {
                mListener.onClick(model)
            }
        }
    }
}