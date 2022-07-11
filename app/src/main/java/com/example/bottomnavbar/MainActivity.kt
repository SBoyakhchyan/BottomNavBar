package com.example.bottomnavbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bottomnavbar.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setCurrentFragment(HomeFragment())

        bottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNavigationView.itemIconTintList = null

        bottomNavigationView.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.home -> {
                    setCurrentFragment(HomeFragment()).addToBackStack(R.string.bottom_nav_item_home.toString())
                    true
                }
                R.id.search -> {
                    setCurrentFragment(SearchFragment()).addToBackStack(R.string.backstack_tag.toString())
                    true
                }
                R.id.cart -> {
                    setCurrentFragment(CartFragment()).addToBackStack(R.string.backstack_tag.toString())
                    true
                }
                R.id.profile -> {
                    setCurrentFragment(ProfileFragment()).addToBackStack(R.string.backstack_tag.toString())
                    true
                }
                R.id.more -> {
                    setCurrentFragment(MoreFragment()).addToBackStack(R.string.backstack_tag.toString())
                    true
                }

                else -> {
                    setCurrentFragment(MoreFragment()).addToBackStack(R.string.backstack_tag.toString())
                    true
                }
            }

        }
        supportActionBar?.hide()
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            add(R.id.nav_container, fragment).commit()
        }
}
