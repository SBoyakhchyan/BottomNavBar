package com.example.bottomnavbar.modelclass

import androidx.annotation.DrawableRes

class SettingsModel(
    @DrawableRes
    var settingIcon: Int,
    var settingName: String,
    var switchButton: Boolean,
)