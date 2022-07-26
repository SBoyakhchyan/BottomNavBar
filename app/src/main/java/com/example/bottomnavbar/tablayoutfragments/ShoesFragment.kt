package com.example.bottomnavbar.tablayoutfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavbar.R
import com.example.bottomnavbar.adapters.CustomAdapterShoes
import com.example.bottomnavbar.modelclass.ShoesClass
import com.example.bottomnavbar.resources.Constants


class ShoesFragment : Fragment(), CustomAdapterShoes.OnItemClickListener {
    private var shoesList = ArrayList<ShoesClass>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapterShoes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_shoes, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        initRecyclerView()
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        divider.setDrawable(requireContext().getDrawable(R.drawable.devider_shoes)!!)
        recyclerView.addItemDecoration(divider)
    }

    private fun initList() {
        shoesList = ArrayList()
        shoesList.add(
            ShoesClass(
                "Reebok Solar Coaster Classic Shoes",
                Constants.IMAGE_URL_REEBOK1, "50000AMD", 1
            )
        )
        shoesList.add(
            ShoesClass(
                "Prove Sport School Shoes For Boys",
                Constants.IMAGE_URL_PROVE_SPORT, "59000AMD"
            )
        )
        shoesList.add(
            ShoesClass(
                "Reebok Olay Range KC Tennis Shoes For Kids",
                Constants.IMAGE_URL_REEBOK_TENNIS, "58000AMD"
            )
        )
        shoesList.add(
            ShoesClass(
                "Nike Sport shoes For Girls",
                Constants.IMAGE_URL_NIKE_GIRLS,
                "60000AMD"
            )
        )
        shoesList.add(
            ShoesClass(
                "Yeghvard Adidas, best sport shoe",
                Constants.YEGHVARD_ADIDAS,
                "13000AMD", 1
            )
        )
        shoesList.add(ShoesClass("Adidas sport", Constants.ADIDAS_SPORT, "55000AMD"))
        shoesList.add(
            ShoesClass(
                "Puma Tazon Modern SL FM Running Shoes For Men",
                Constants.PUMA_TAZON_MODERN_FOR_MAN, "52000AMD", 1
            )
        )
        shoesList.add(
            ShoesClass(
                "Fila man Stackhouse Spaghetti",
                Constants.FILA_MEN_STACKHOUSE_SPAGHETTI, "45000AMD", 1
            )
        )
    }

    private fun initRecyclerView() {
        recyclerView = requireView().findViewById(R.id.recyclerViewShoes)
        adapter = CustomAdapterShoes(shoesList)
        adapter.setListener(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onItemClick(shoes: ShoesClass) {
        val action = ShoesFragmentDirections.actionShoesFragmentToShoeItemFragment(
            shoes.shoeBrand,
            shoes.price,
            shoes.imageUrl
        )
        findNavController().navigate(action)
    }
}