package com.example.bottomnavbar.drawerfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.bottomnavbar.CustomAdapter
import com.example.bottomnavbar.R
import com.example.bottomnavbar.User

class AddHiddenNetwork : Fragment() {
    private lateinit var listView: ListView
    private var userNameList = ArrayList<User>()
    private lateinit var customAdapter: CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_hidden_network, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
    }

    private fun initList() {
        userNameList = ArrayList()
        userNameList.add(User("Bob"))
        userNameList.add(User("John"))
        userNameList.add(User("Jack"))
        userNameList.add(User("Sean"))
        userNameList.add(User("Nike"))

        customAdapter = CustomAdapter(
            requireContext(),
            R.layout.item_user,
            userNameList
        )

        listView = requireView().findViewById(R.id.listView)
        listView.adapter = customAdapter

    }
}