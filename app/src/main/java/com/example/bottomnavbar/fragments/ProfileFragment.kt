package com.example.bottomnavbar.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavbar.R
import com.example.bottomnavbar.databinding.FragmentProfileBinding
import com.example.bottomnavbar.resources.Constants

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentProfileBinding.bind(view)
        preferences = getPreferences(requireContext())
        binding.etProfile.setText(preferences.getString(Constants.TEXT_VALUE_GET, ""))

        binding.btnPrefSave.setOnClickListener {
            val value = binding.etProfile.text.toString()
            preferences.edit()
                .putString(Constants.TEXT_VALUE_GET, value)
                .commit()
        }
    }

    companion object {
        fun getPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE)

    }
}