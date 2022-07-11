package com.example.bottomnavbar.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.bottomnavbar.R
import com.example.bottomnavbar.SectionAdapter
import com.example.bottomnavbar.tablayoutfragments.ApparelFragment
import com.example.bottomnavbar.tablayoutfragments.BeautyFragment
import com.example.bottomnavbar.tablayoutfragments.ShoesFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class CartFragment : Fragment() {
    private lateinit var tabLayout: TabLayout
    private lateinit var pager: ViewPager2
    private lateinit var adapter: SectionAdapter
    private var list = ArrayList<Fragment>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setList()
        initPager()
        initTabLayout()
    }

    private fun initView() {
        tabLayout = requireView().findViewById(R.id.tl_fragment_tabs)
        pager = requireView().findViewById(R.id.vp_fragment_viewpager)
    }

    private fun initTabLayout() {
        TabLayoutMediator(tabLayout, pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.tab_text_apparel)
                    tab.setIcon(R.drawable.ic_apparel)
                    tab.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.teal_700))
                }
                1 -> {
                    tab.text = getString(R.string.tab_text_beauty)
                    tab.setIcon(R.drawable.ic_beauty)
                    tab.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.purple_500))
                    tab.icon?.alpha = 60
                }
                2 -> {
                    tab.text = getString(R.string.tab_text_shoes)
                    tab.setIcon(R.drawable.ic_shoes)
                    tab.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.teal_200))
                    tab.icon?.alpha = 60

                }
            }
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.icon?.alpha = 250
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.alpha = 60
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
    }

    private fun initPager() {
        adapter = SectionAdapter(childFragmentManager, lifecycle, list)
        pager.adapter = adapter
    }

    private fun setList() {
        list.add(ApparelFragment())
        list.add(BeautyFragment())
        list.add(ShoesFragment())
    }

}