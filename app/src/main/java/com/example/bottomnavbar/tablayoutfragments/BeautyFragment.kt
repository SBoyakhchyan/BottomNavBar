package com.example.bottomnavbar.tablayoutfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getDrawable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavbar.Beauty
import com.example.bottomnavbar.BeautyAdapter
import com.example.bottomnavbar.Constants
import com.example.bottomnavbar.R

class BeautyFragment : Fragment() {
    private val list = ArrayList<Beauty>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BeautyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beauty, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        setList()
        initRecyclerView()
        val divider = DividerItemDecoration(context,DividerItemDecoration.VERTICAL)
        divider.setDrawable(requireContext().getDrawable(R.drawable.devider)!!)
        recyclerView.addItemDecoration(divider)
    }

    private fun initRecyclerView() {
        recyclerView = requireView().findViewById(R.id.recyclerViewBeauty)
        adapter = BeautyAdapter(list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun setList() {
        list.add(Beauty(Constants.BEAUTY_TITLE_1, Constants.BEAUTY_PIC_1))
        list.add(Beauty(Constants.BEAUTY_TITLE_2, Constants.BEAUTY_PIC_2))
        list.add(Beauty(Constants.BEAUTY_TITLE_3, Constants.BEAUTY_PIC_3))
        list.add(Beauty(Constants.BEAUTY_TITLE_4, Constants.BEAUTY_PIC_4))
    }
}