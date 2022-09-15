package com.example.bottomnavbar.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavbar.R
import com.example.bottomnavbar.databinding.ItemPhoneContactBinding

class ContactAdapter(
    val contactCursor: Cursor,
    val itemClick: (phoneNumber: String) -> Boolean
) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    private lateinit var binding: ItemPhoneContactBinding
    private var cursor = contactCursor

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactName: AppCompatTextView
        val contactNumber: AppCompatTextView


        init {
            binding = ItemPhoneContactBinding.bind(itemView)
            contactName = binding.tvContactName
            contactNumber = binding.tvContactNumber
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_phone_contact, parent, false)
        return ContactViewHolder(itemView)
    }

    fun changeCursor(newCursor: Cursor?) {
        if (newCursor != null) {
            cursor = newCursor
            notifyDataSetChanged()
        }

    }

    @SuppressLint("Range")
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        cursor.moveToNext()
        val name: String =
            cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
        val number =
            cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
        holder.apply {
            contactName.text = name
            contactNumber.text = number
            itemView.setOnClickListener{

                itemClick.apply {
                    invoke("tel:$number")
                    invoke("sms:$number")
                }
            }
        }
    }

    override fun getItemCount(): Int = cursor.count

}