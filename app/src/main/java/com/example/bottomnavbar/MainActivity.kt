package com.example.bottomnavbar

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
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
import com.example.bottomnavbar.resources.Constants.Companion.BOOL_LIST_KEY
import com.example.bottomnavbar.resources.Constants.Companion.SETTING_IS_ENABLE
import com.example.bottomnavbar.resources.Constants.Companion.getSharedForSettings
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var navController: NavController
    //private lateinit var drawerNavController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var settingShared: SharedPreferences
    private var settingSwitchBoolList = mutableListOf<Boolean>()
    private var isDefaultSet: Boolean = true


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
                        navController.navigate(R.id.drawer_nav_graph)
                        toastForDrawer("Network selected")
                    }
                    R.id.wifiOnMap -> {
                        toastForDrawer("WiFi choosen")
                    }
                    R.id.dataUsage -> {
                        toastForDrawer("Used data opened")
                    }
                    R.id.add_hidden_network -> {
                        //navController.navInflater.inflate(R.navigation.drawer_nav_graph)
                        navController.navigate(R.id.drawer_nav_graph)
                        toastForDrawer("Add hidden networks selected")
                    }
                    R.id.settings -> {
                        navController.navigate(R.id.action_homeFragment_to_settings2)
                    }
                }
                drawerLayout.closeDrawer(GravityCompat.START)
                true
            }

        }
        setSettingShared()
        addSettingBoolLIst(isDefaultSet)
        initView()
        setupNavController()

        //drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)


    }

    private fun addSettingBoolLIst(isAdded: Boolean) {
        if (isAdded) {
            settingSwitchBoolList.add(true)
            settingSwitchBoolList.add(false)
            settingSwitchBoolList.add(true)
            settingSwitchBoolList.add(true)
            val gson = Gson()
            val json = gson.toJson(settingSwitchBoolList)
            settingShared.edit()
                .putString(SETTING_IS_ENABLE, json)
                .apply()
            setIsDefaultSet()
        }
    }

    private fun setSettingShared() {
        settingShared = getSharedForSettings()
        // get boolean key
        isDefaultSet = settingShared.getBoolean(BOOL_LIST_KEY, true)
    }

    private fun setIsDefaultSet() {
        if (isDefaultSet)
            settingShared.edit()
                .putBoolean(BOOL_LIST_KEY, false)
                .apply()
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (toggle.onOptionsItemSelected(item)) {
//            true
//        }
//        return super.onOptionsItemSelected(item)
//    }


    private fun setupNavController() {
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNav.setupWithNavController(navController)
    }


    private fun initView() {
        drawerLayout = binding.drawerLayout
        bottomNav = binding.bottomNavigation
       // bottomNav = findViewById(R.id.bottomNavigation)
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