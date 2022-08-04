package com.example.bottomnavbar.fragments

//import android.widget.SearchView
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.bottomnavbar.R
import com.example.bottomnavbar.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var searchView: SearchView
    private lateinit var listViewSearch: ListView
    private lateinit var binding: FragmentSearchBinding

    var columns = listOf(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID
    ).toTypedArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        requireActivity().actionBar?.setDisplayHomeAsUpEnabled(false)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        binding = FragmentSearchBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        searchView = binding.searchView
        listViewSearch = view.findViewById(R.id.listViewSearch)
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                Array(1) { Manifest.permission.READ_CONTACTS },
                111
            )
        } else {
            readContact()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun shouldShowRequestPermissionRationale(permission: String): Boolean {
        if (permission == "PERMISSION_GRANTED")
            readContact()
        return super.shouldShowRequestPermissionRationale(permission)

    }
//    override fun registerForActivityResult(
//        requestCode: Int,
//        permission: Array<out String>,
//        grantResults: IntArray
//    ) {
//        if (requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
//            readContact()
//    }


    @SuppressLint("Recycle")
    private fun readContact() {
        val from = listOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        ).toTypedArray()
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)


        var resolver = requireActivity().contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            columns,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )

        val adapter = SimpleCursorAdapter(
            requireContext(),
            android.R.layout.simple_list_item_2,
            resolver,
            from,
            to,
            0
        )
        listViewSearch.adapter = adapter


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                resolver = requireActivity().contentResolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    columns,
                    "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?",
                    Array(1) { "%$newText%" },
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                )
                adapter.changeCursor(resolver)
                return false
            }
        })
    }
}