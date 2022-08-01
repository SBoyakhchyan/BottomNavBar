package com.example.bottomnavbar.drawerfragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavbar.R
import com.example.bottomnavbar.adapters.SettingsAdapter
import com.example.bottomnavbar.databinding.FragmentSettingsBinding
import com.example.bottomnavbar.modelclass.SettingsModel
import com.example.bottomnavbar.resources.Constants
import com.example.bottomnavbar.resources.Constants.Companion.SETTING_IS_ENABLE
import com.google.gson.Gson

class Settings : Fragment() {
    private var settingsList = mutableListOf<SettingsModel>()
    private lateinit var recyclerViewSettings: RecyclerView
    private lateinit var adapterSettings: SettingsAdapter
    private lateinit var binding: FragmentSettingsBinding
    private lateinit var settingShared: SharedPreferences
    private lateinit var settingSwitchBoolList: Array<Boolean>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        binding = FragmentSettingsBinding.bind(view)

        setSharedSetting()
        getSettingBoolList()
        setList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun setList() {
        settingsList = ArrayList()
        val settingCamera = SettingsModel((R.drawable.ic_camera), "Camera", settingSwitchBoolList[0])
        val settingContacts = SettingsModel((R.drawable.ic_contacts), "Contacts", settingSwitchBoolList[1])
        val settingLocation = SettingsModel((R.drawable.ic_location), "Location", settingSwitchBoolList[2])
        val settingStorage = SettingsModel((R.drawable.ic_folder), "Storage", settingSwitchBoolList[3])

        settingsList.add(settingCamera)
        settingsList.add(settingContacts)
        settingsList.add(settingLocation)
        settingsList.add(settingStorage)
    }

    private fun initRecyclerView() {
        recyclerViewSettings = binding.recyclerViewSettings
        adapterSettings = SettingsAdapter(settingsList)
        recyclerViewSettings.adapter = adapterSettings
        recyclerViewSettings.layoutManager = LinearLayoutManager(context)
    }

    private fun getSettingBoolList() {
        val gson = Gson()
        settingSwitchBoolList = gson.fromJson(
            settingShared.getString(SETTING_IS_ENABLE, ""),
            Array<Boolean>::class.java
        )
    }

    private fun setSharedSetting() {
        settingShared = Constants.getSharedForSettings(requireContext())
    }

}