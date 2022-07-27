package com.example.bottomnavbar.fragments

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomnavbar.R
import com.example.bottomnavbar.databinding.FragmentMoreBinding
import com.example.bottomnavbar.resources.Constants

class MoreFragment : Fragment() {
    private lateinit var binding: FragmentMoreBinding
    private lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_more, container, false)
        binding = FragmentMoreBinding.bind(view)
         preferences  = ProfileFragment.getPreferences(requireContext())
        binding.tvMore.text = preferences.getString(Constants.TEXT_VALUE_GET,"")
        return binding.root
    }
}