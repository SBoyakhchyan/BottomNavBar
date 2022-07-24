package com.example.bottomnavbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapterShoes(
    var listShoes: List<ShoesClass>
) : RecyclerView.Adapter<CustomAdapterShoes.ShoesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_user_shoes, parent, false)
        return ShoesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoesViewHolder, position: Int) {
        val shoes = listShoes[position]
        holder.apply {
            shoeText.text = shoes.shoeBrand
            price.text = shoes.price
            Glide.with(itemView).load(shoes.imageUrl).into(imageShoes)
        }
    }

    override fun getItemCount(): Int {
        return listShoes.size
    }

    class ShoesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shoeText: AppCompatTextView
        val imageShoes: AppCompatImageView
        val price: AppCompatTextView

        init {
            shoeText = itemView.findViewById(R.id.shoe_text)
            imageShoes = itemView.findViewById(R.id.image_shoes)
            price = itemView.findViewById(R.id.tvPrice)

        }
    }


}