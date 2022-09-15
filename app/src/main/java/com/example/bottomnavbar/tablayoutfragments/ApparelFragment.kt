package com.example.bottomnavbar.tablayoutfragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomnavbar.R
import com.example.bottomnavbar.databinding.FragmentApparelBinding
import com.example.bottomnavbar.modelclass.UserData
import com.example.bottomnavbar.resources.Constants.Companion.getService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.fragment.app.Fragment

class ApparelFragment : Fragment() {
    private lateinit var binding: FragmentApparelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_apparel, container, false)
        binding = FragmentApparelBinding.bind(view)
        return view
    }

    private fun requestData() {
        val service = getService()
        service.getPost().enqueue(object : Callback<UserData> {
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                if (response.isSuccessful) {
                    binding.tvApparel.text = buildString {
                        append("id of the user is ")
                        append(response.body()?.id.toString())
                    }
                    //Log.d("TAG", "onResponse: ${response.body()?.toString()}")
                }
            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {
                Log.d("TAG", "onResponse: ${t.message}")
            }
        })


    }

}