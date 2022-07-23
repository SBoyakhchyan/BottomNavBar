package com.example.bottomnavbar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.bumptech.glide.Glide

class CustomAdapterShoes(
    context: Context,
    @LayoutRes
    var resource: Int,
    var list: List<ShoesClass>
) : ArrayAdapter<ShoesClass>(context, resource, list) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)

        val rowView: View = inflater.inflate(resource, null, true)

        val shoeBrand = rowView.findViewById<AppCompatTextView>(R.id.shoe_text)
        val image = rowView.findViewById<AppCompatImageView>(R.id.image_shoes)

        shoeBrand.text = list[position].shoeBrand
        Glide.with(context).load(list[position].imageUrl).into(image)

        return rowView
    }

}
