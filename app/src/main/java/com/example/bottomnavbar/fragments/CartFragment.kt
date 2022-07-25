package com.example.bottomnavbar.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.bottomnavbar.R
import com.example.bottomnavbar.adapters.SectionAdapter
import com.example.bottomnavbar.databinding.FragmentCartBinding
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
    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCartBinding.inflate(inflater, container, false)
        binding.apply { registerForContextMenu(this.myToolbar) }
        binding.apply { registerForContextMenu(this.ivBackArrow) }

        return binding.root
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val inflater: MenuInflater = requireActivity().menuInflater
        inflater.inflate(R.menu.menu_three_dots, menu)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        setList()
        initPager()
        initTabLayout()
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save -> {
                Toast.makeText(context, "saved", Toast.LENGTH_SHORT).show()
            }
            R.id.delete -> {
                Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show()
            }
            R.id.search -> {
                Toast.makeText(context, "searched", Toast.LENGTH_SHORT).show()
            }
            R.id.sync -> {
                Toast.makeText(context, "synced", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }


    private fun initView() {
        binding = FragmentCartBinding.bind(requireView())
        tabLayout = binding.tlFragmentTabs
        pager = binding.vpFragmentViewpager
    }

    private fun initTabLayout() {
        TabLayoutMediator(tabLayout, pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.one_tab)
                    tab.setIcon(R.drawable.ic_heart_broken)
                    tab.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.white))
                }
                1 -> {
                    tab.text = getString(R.string.two_tab)
                    tab.setIcon(R.drawable.ic_phone)
                    tab.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.white))
                }
                2 -> {
                    tab.text = getString(R.string.three_tab)
                    tab.setIcon(R.drawable.ic_account)
                    tab.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.white))
                }
            }
        }.attach()
    }
//second
//    private fun initTabLayout() {
//        TabLayoutMediator(tabLayout, pager) { tab, position ->
//           when (position) {
//               0 -> {
//                   tab.text = getString(R.string.first_tab)
//                }
//                1 -> {
//                    tab.text = getString(R.string.second_tab)
//                                    }
//                2 -> {
//                    tab.text = getString(R.string.third_tab)
//                }
//            }
//        }.attach()
//    }
// first
//    private fun initTabLayout() {
//        TabLayoutMediator(tabLayout, pager) { tab, position ->
//            when (position) {
//                0 -> {
//                    tab.text = getString(R.string.tab_text_apparel)
//                    tab.setIcon(R.drawable.ic_apparel)
//                    tab.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.teal_700))
//                }
//                1 -> {
//                    tab.text = getString(R.string.tab_text_beauty)
//                    tab.setIcon(R.drawable.ic_beauty)
//                    tab.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.purple_500))
//                    tab.icon?.alpha = 60
//                }
//                2 -> {
//                    tab.text = getString(R.string.tab_text_shoes)
//                    tab.setIcon(R.drawable.ic_shoes)
//                    tab.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.teal_200))
//                    tab.icon?.alpha = 60
//                }
//            }
//        }.attach()
//
//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                tab.icon?.alpha = 250
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab) {
//                tab.icon?.alpha = 60
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {}
//
//        })
//    }

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