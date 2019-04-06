package com.example.beetlestance.benji

import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.example.beetlestance.benji.databinding.ActivityMainBinding
import com.example.beetlestance.benji.ui.BottomNavigationDrawerFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_navigation_fragment.*

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this@MainActivity).get(MainActivityViewModel::class.java)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.todoFragment, R.id.about))
        //setUpNavigation()
        setSupportActionBar(bottom_app_bar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottom_app_bar_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
        }
        return true
    }

    /*override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
    }
*/
    /*private fun setUpNavigation() {
        val navController = findNavController(R.id.nav_host_fragment)
        setSupportActionBar(toolBar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navBar.setNavigationItemSelectedListener { menuItem ->
            if (menuItem!=navBar.checkedItem){menuItem.onNavDestinationSelected(navController)}
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }*/
}




