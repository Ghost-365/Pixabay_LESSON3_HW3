package com.example.pixabay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pixabay.databinding.ItemImageBinding

class PixaAdapter {

    class PixaAdapter(var list: ArrayList<Hit>) : RecyclerView.Adapter<PixaAdapter.PixaViewHolder>() {

        fun addData(list:List<Hit>){
            this.list.addAll(list)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixaViewHolder {
            return PixaViewHolder(
                ItemImageBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false            )
            )
        }

        override fun onBindViewHolder(holder: PixaViewHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount(): Int {
            return list.size    }

        class PixaViewHolder(private val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(hit: Hit) {
                binding.imageView.load(hit.largeImageURL)
            }
        }

    }

}