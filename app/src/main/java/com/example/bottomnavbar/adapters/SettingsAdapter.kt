package com.example.bottomnavbar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bottomnavbar.R
import com.example.bottomnavbar.databinding.ItemSettingsBinding
import com.example.bottomnavbar.modelclass.SettingsModel
import com.example.bottomnavbar.resources.Constants
import com.example.bottomnavbar.resources.Constants.Companion.SETTING_IS_ENABLE
import com.google.gson.Gson

class SettingsAdapter(
    var listSettings: List<SettingsModel>
) : RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder>() {
    private lateinit var bindingItemSettingsBinding: ItemSettingsBinding
    private lateinit var boolList: Array<Boolean>
    private val gson = Gson()

    inner class SettingsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: AppCompatImageView
        val settingName: AppCompatTextView
        val switchBtn: SwitchCompat

        init {
            icon = itemView.findViewById(R.id.iv_iconCamera)
            settingName = itemView.findViewById(R.id.tv_1st_setting)
            switchBtn = itemView.findViewById(R.id.btn_switchSetting)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_settings, parent, false)
        bindingItemSettingsBinding = ItemSettingsBinding.bind(itemView)
        return SettingsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        val setting = listSettings[position]
        holder.apply {
            val shared = Constants.getSharedForSettings(itemView.context)
            boolList =
                gson.fromJson(shared.getString(SETTING_IS_ENABLE, ""), Array<Boolean>::class.java)
            settingName.text = setting.settingName
            switchBtn.isChecked = setting.switchButton
            Glide.with(itemView.context).load(setting.settingIcon).into(icon)
            switchBtn.setOnCheckedChangeListener { _, isChecked ->
                boolList[position] = isChecked
                shared.edit()
                    .putString(SETTING_IS_ENABLE, gson.toJson(boolList))
                    .apply()
            }
        }
    }

    override fun getItemCount(): Int {
        return listSettings.size
    }

}