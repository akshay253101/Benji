package com.example.beetlestance.benji

import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import com.example.beetlestance.benji.databinding.ActivityMainBinding
import com.example.beetlestance.benji.ui.BottomNavigationDrawerFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this@MainActivity).get(MainActivityViewModel::class.java)
        nav_host_fragment.childFragmentManager.executePendingTransactions()
        setupBottomAppBar()
    }

    private fun setupBottomAppBar() {
        bottom_app_bar.replaceMenu(R.menu.bottom_app_bar_item)
        bottom_app_bar.setNavigationOnClickListener {
            val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
            bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
        }
    }
    /*override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
    }*/

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




