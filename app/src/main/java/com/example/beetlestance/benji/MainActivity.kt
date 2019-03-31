package com.example.beetlestance.benji

import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.example.beetlestance.benji.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this@MainActivity).get(MainActivityViewModel::class.java)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.todoFragment, R.id.about), drawerLayout)
        setUpNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
    }

    private fun setUpNavigation() {
        val navController = findNavController(R.id.nav_host_fragment)
        setSupportActionBar(toolBar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navBar.setNavigationItemSelectedListener { menuItem ->
            if (menuItem!=navBar.checkedItem){menuItem.onNavDestinationSelected(navController)}
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }
}




