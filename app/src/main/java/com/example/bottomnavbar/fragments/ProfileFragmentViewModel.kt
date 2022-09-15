package com.example.bottomnavbar.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileFragmentViewModel() : ViewModel() {
    var integer = 0
    val liveData = MutableLiveData<Int>(1)


}