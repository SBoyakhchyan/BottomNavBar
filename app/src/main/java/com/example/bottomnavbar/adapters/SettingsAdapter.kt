package com.example.bottomnavbar.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bottomnavbar.databinding.ItemSettingsBinding
import com.example.bottomnavbar.modelclass.SettingsModel

class SettingsAdapter(
    var listSettings: List<SettingsModel>,
    var itemCallBack: (position: Int, isChecked: Boolean) -> Unit
) : RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        val bindingSettings = ItemSettingsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return SettingsViewHolder(bindingSettings)
    }

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        with(listSettings[position]) {
            holder.apply {
                bindingSettings.tv1stSetting.text = settingName
                bindingSettings.btnSwitchSetting.isChecked = switchButton
                Glide.with(itemView.context).load(settingIcon).into(bindingSettings.ivIconCamera)
                bindingSettings.btnSwitchSetting.setOnCheckedChangeListener { _, isChecked ->
                    itemCallBack.invoke(position, isChecked)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listSettings.size
    }

    inner class SettingsViewHolder(val bindingSettings: ItemSettingsBinding) :
        RecyclerView.ViewHolder(bindingSettings.root)
}