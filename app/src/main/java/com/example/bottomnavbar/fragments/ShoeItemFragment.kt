package com.example.bottomnavbar.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.bottomnavbar.R
import com.example.bottomnavbar.databinding.FragmentShoeItemBinding

class ShoeItemFragment : Fragment() {
    private lateinit var binding: FragmentShoeItemBinding
    private val args: ShoeItemFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shoe_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShoeItemBinding.bind(view)

        binding.textTV.text = args.textTV
        binding.priceTV.text = args.priceTV
        Glide.with(requireContext()).load(args.imageIV).into(binding.imageIV)
    }

}