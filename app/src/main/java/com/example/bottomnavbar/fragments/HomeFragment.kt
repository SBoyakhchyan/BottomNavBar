package com.example.bottomnavbar.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bottomnavbar.R
import com.example.bottomnavbar.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding.imApparel.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_apparelFragment)
        }
        binding.imBeauty.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_beautyFragment)
        }
        binding.imShoes.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_shoesFragment)
        }
    }

}