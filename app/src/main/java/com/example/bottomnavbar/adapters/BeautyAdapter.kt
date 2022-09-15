package com.example.bottomnavbar.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bottomnavbar.databinding.ItemBeautyBinding
import com.example.bottomnavbar.modelclass.Beauty

//class BeautyAdapter(var listBeauty: List<Beauty>) :
//    RecyclerView.Adapter<BeautyAdapter.BeautyViewHolder>() {
//    private lateinit var bindingBeautyAdapter: ItemBeautyBinding
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeautyViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val view = layoutInflater.inflate(R.layout.item_beauty, parent, false)
//        bindingBeautyAdapter = ItemBeautyBinding.bind(view)
//        return BeautyViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: BeautyViewHolder, position: Int) {
//        val beauty = listBeauty[position]
//        holder.apply {
//            title.text = beauty.title
//            Glide.with(itemView).load(beauty.imageUrl).into(image)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return listBeauty.size
//    }
//
//    inner class BeautyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val title: AppCompatTextView
//        val image: AppCompatImageView
//
//        init {
//            title = bindingBeautyAdapter.tvTitle //itemView.findViewById(R.id.tvTitle)
//            image = bindingBeautyAdapter.imageBeauty //itemView.findViewById(R.id.imageBeauty)
//        }
//    }
//}

class BeautyAdapter(var listBeauty: List<Beauty>) :
    RecyclerView.Adapter<BeautyAdapter.BeautyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeautyViewHolder {
        val binding = ItemBeautyBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BeautyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeautyViewHolder, position: Int) {
        with(listBeauty[position]) {
            holder.apply {
                binding.tvTitle.text = title
                Glide.with(itemView).load(imageUrl).into(binding.imageBeauty)
            }
        }
    }

    override fun getItemCount(): Int {
        return listBeauty.size
    }

    inner class BeautyViewHolder(val binding: ItemBeautyBinding) :
        RecyclerView.ViewHolder(binding.root)
}