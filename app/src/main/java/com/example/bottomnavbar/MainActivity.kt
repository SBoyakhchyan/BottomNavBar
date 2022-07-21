package com.example.bottomnavbar

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavbar.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//  private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
//            toggle = ActionBarDrawerToggle(
//                this@MainActivity,
//                drawerLayout,
//                R.string.open_drawer,
//                R.string.close_drawerr
//            )
//            drawerLayout.addDrawerListener(toggle)
//            toggle.syncState()
//           supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navDrawerView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.networkItem -> {
                        toastForDrawer("Network selected")
                    }
                    R.id.wifiOnMap -> {
                        toastForDrawer("WiFi choosen")
                    }
                    R.id.dataUsage -> {
                        toastForDrawer("Used data opened")
                    }
                    R.id.add_hidden_network -> {
                        navController.navigate(R.id.drawer_nav_graph)
                    }
                }
                drawerLayout.closeDrawer(GravityCompat.START)
                true
            }

        }
        initView()

        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNav.setupWithNavController(navController)

        //drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (toggle.onOptionsItemSelected(item)) {
//            true
//        }
//        return super.onOptionsItemSelected(item)
//    }

    private fun initView() {
        drawerLayout = binding.drawerLayout
        bottomNav = findViewById(R.id.bottomNavigation)
        navController = findNavController(R.id.container_root)
    }


    override fun onBackPressed() {
        if (navController.currentDestination != navController.findDestination(R.id.homeFragment))
            super.onBackPressed()
        else navController.popBackStack()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun toastForDrawer(text: String) {
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT)
            .show()
    }
}