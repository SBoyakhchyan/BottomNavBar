package com.example.bottomnavbar.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bottomnavbar.R
import com.example.bottomnavbar.databinding.FragmentProfileBinding
import com.example.bottomnavbar.resources.Constants

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var preferences: SharedPreferences
    private val viewModel : ProfileFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentProfileBinding.bind(view)
        preferences = getPreferences(requireContext())
        binding.etProfile.setText(preferences.getString(Constants.TEXT_VALUE_GET, ""))
            binding.btnPrefSave.setOnClickListener{
                viewModel.liveData.value = viewModel.liveData.value?.plus(1)
                viewModel.liveData.observe(viewLifecycleOwner){
                    binding.etProfile.setText(it.toString())
                }
            }
//        binding.btnPrefSave.setOnClickListener {
//            val value = binding.etProfile.text.toString()
//            preferences.edit()
//                .putString(Constants.TEXT_VALUE_GET, value)
//                .apply()
//        }
    }

    companion object {
        fun getPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE)

    }
}