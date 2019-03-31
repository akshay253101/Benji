package com.example.beetlestance.benji

import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.beetlestance.benji.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this@MainActivity).get(MainActivityViewModel::class.java)
        setUpNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navigateUp(findNavController(R.id.nav_host_fragment), drawerLayout)
    }

    private fun setUpNavigation(){
        val navController = findNavController(R.id.nav_host_fragment)
        toolBar.setupWithNavController(navController,drawerLayout)
        navBar.setNavigationItemSelectedListener{
            menuItem -> menuItem.isChecked =true
            drawerLayout.closeDrawers()
            true
        }
        setupWithNavController(navBar,navController)
    }

}




