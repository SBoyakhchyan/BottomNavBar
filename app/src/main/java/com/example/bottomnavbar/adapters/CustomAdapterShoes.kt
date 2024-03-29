package com.example.bottomnavbar.adapters


import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bottomnavbar.R
import com.example.bottomnavbar.databinding.ItemUserShoesBinding
import com.example.bottomnavbar.databinding.ItemUserShoesSecondBinding
import com.example.bottomnavbar.modelclass.ShoesClass

//class CustomAdapterShoes(
//    var listShoes: List<ShoesClass>
//) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    var selectPosition = -1
//    var onItemClickListener: OnItemClickListener? = null
//
//    override fun getItemViewType(position: Int): Int {
//        return listShoes[position].type
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return if (viewType == 1) {
//            val itemView =
//                LayoutInflater.from(parent.context)
//                    .inflate(R.layout.item_user_shoes, parent, false)
//            ShoesViewHolder(itemView)
//        } else {
//            val itemView =
//                LayoutInflater.from(parent.context)
//                    .inflate(R.layout.item_user_shoes_second, parent, false)
//            ShoesViewHolderSecond(itemView)
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val shoes = listShoes[position]
//        holder.apply {
//            if (selectPosition == position) {
//                itemView.setBackgroundColor(Color.YELLOW)
//            } else {
//                itemView.setBackgroundColor(Color.MAGENTA)
//            }
//            when (this) {
//                is ShoesViewHolder -> {
//                    shoeText.text = shoes.shoeBrand
//                    price.text = shoes.price
//                    Glide.with(itemView).load(shoes.imageUrl).into(imageShoes)
//                    itemView.setOnClickListener {
//                        selectPosition = absoluteAdapterPosition
//                        Toast.makeText(
//                            itemView.context,
//                            String.format(
//                                itemView.context.getString(R.string.CustomAdapterShoesToastText),
//                                price.text,
//                                position + 1
//                            ),
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        notifyDataSetChanged()
//                        onItemClickListener?.onItemClick(shoes)
//                    }
//                }
//                is ShoesViewHolderSecond -> {
//                    shoeTextSecond.text = shoes.shoeBrand
//                    priceSecond.text = shoes.price
//                    Glide.with(itemView).load(shoes.imageUrl).into(imageShoesSecond)
//                    itemView.setOnClickListener {
//                        val nav = it.findNavController()
//                        nav.navigate(R.id.action_shoesFragment_to_addHiddenNetwork2)
//                        selectPosition = absoluteAdapterPosition
//                        Toast.makeText(
//                            itemView.context,
//                            String.format(
//                                itemView.context.getString(R.string.CustomAdapterShoesToastText),
//                                priceSecond.text,
//                                position + 1
//                            ),
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        notifyDataSetChanged()
//                    }
//                }
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return listShoes.size
//    }
//
//    fun setListener(onItemClickListener: OnItemClickListener) {
//        this.onItemClickListener = onItemClickListener
//    }
//
//    interface OnItemClickListener {
//        fun onItemClick(shoes: ShoesClass)
//    }
//
//
//    inner class ShoesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val shoeText: AppCompatTextView
//        val imageShoes: AppCompatImageView
//        val price: AppCompatTextView
//
//        init {
//            shoeText = itemView.findViewById(R.id.shoe_text)
//            imageShoes = itemView.findViewById(R.id.image_shoes)
//            price = itemView.findViewById(R.id.tvPrice)
//        }
//    }
//
//    inner class ShoesViewHolderSecond(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val shoeTextSecond: AppCompatTextView
//        val imageShoesSecond: AppCompatImageView
//        val priceSecond: AppCompatTextView
//
//        init {
//            shoeTextSecond = itemView.findViewById(R.id.shoe_text_second)
//            imageShoesSecond = itemView.findViewById(R.id.image_shoes_second)
//            priceSecond = itemView.findViewById(R.id.tvPrice_second)
//        }
//    }
//}

class CustomAdapterShoes(
    private var listShoes: List<ShoesClass>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var selectPosition = -1
    private var onItemClickListener: OnItemClickListener? = null

    override fun getItemViewType(position: Int): Int {
        return listShoes[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {
            val bindingShoesAdapter = ItemUserShoesBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            ShoesViewHolder(bindingShoesAdapter)
        } else {
            val bindingShoesAdapterSecond = ItemUserShoesSecondBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            ShoesViewHolderSecond(bindingShoesAdapterSecond)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val shoes = listShoes[position]
        holder.apply {
            if (selectPosition == position) {
                itemView.setBackgroundColor(Color.YELLOW)
            } else {
                itemView.setBackgroundColor(Color.MAGENTA)
            }
            when (this) {
                is ShoesViewHolder -> {
                    bindingShoesAdapter.apply {
                        shoeText.text = shoes.shoeBrand
                        tvPrice.text = shoes.price
                        Glide.with(itemView).load(shoes.imageUrl).into(imageShoes)
                        itemView.setOnClickListener {
                            selectPosition = absoluteAdapterPosition
                            Toast.makeText(
                                itemView.context,
                                String.format(
                                    itemView.context.getString(R.string.CustomAdapterShoesToastText),
                                    tvPrice.text,
                                    position + 1
                                ),
                                Toast.LENGTH_SHORT
                            ).show()
                            notifyDataSetChanged()
                            onItemClickListener?.onItemClick(shoes)
                        }
                    }
                }
                is ShoesViewHolderSecond -> {
                    bindingShoesAdapterSecond.apply{
                        shoeTextSecond.text = shoes.shoeBrand
                        tvPriceSecond.text = shoes.price
                        Glide.with(itemView).load(shoes.imageUrl)
                            .into(imageShoesSecond)
                        itemView.setOnClickListener {
                            val nav = it.findNavController()
                            nav.navigate(R.id.action_shoesFragment_to_addHiddenNetwork2)
                            selectPosition = absoluteAdapterPosition
                            Toast.makeText(
                                itemView.context,
                                String.format(
                                    itemView.context.getString(R.string.CustomAdapterShoesToastText),
                                    tvPriceSecond.text,
                                    position + 1
                                ),
                                Toast.LENGTH_SHORT
                            ).show()
                            notifyDataSetChanged()
                        }
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listShoes.size
    }

    fun setListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(shoes: ShoesClass)
    }


    inner class ShoesViewHolder(val bindingShoesAdapter: ItemUserShoesBinding) :
        RecyclerView.ViewHolder(bindingShoesAdapter.root)

    inner class ShoesViewHolderSecond(val bindingShoesAdapterSecond: ItemUserShoesSecondBinding) :
        RecyclerView.ViewHolder(bindingShoesAdapterSecond.root)
}