package com.example.bottomnavbar.api

import com.example.bottomnavbar.modelclass.UserData
import com.example.bottomnavbar.resources.Constants.Companion.END_POINT
import retrofit2.Call
import retrofit2.http.GET

interface SimpleApi {
    @GET(END_POINT)
    fun getPost(): Call<UserData>
}