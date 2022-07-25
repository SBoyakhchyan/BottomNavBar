package com.example.bottomnavbar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bottomnavbar.modelclass.Beauty
import com.example.bottomnavbar.R

class BeautyAdapter(var listBeauty: List<Beauty>) :
    RecyclerView.Adapter<BeautyAdapter.BeautyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeautyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_beauty, parent, false)
        return BeautyViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeautyViewHolder, position: Int) {
        val beauty = listBeauty[position]
        holder.apply {
            title.text = beauty.title
            Glide.with(itemView).load(beauty.imageUrl).into(image)
        }
    }

    override fun getItemCount(): Int {
        return listBeauty.size
    }

    class BeautyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: AppCompatTextView
        val image: AppCompatImageView

        init {
            title = itemView.findViewById(R.id.tvTitle)
            image = itemView.findViewById(R.id.imageBeauty)
        }
    }


}