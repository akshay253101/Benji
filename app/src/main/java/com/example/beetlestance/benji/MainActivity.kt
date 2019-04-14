package com.example.beetlestance.benji

import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import com.example.beetlestance.benji.databinding.ActivityMainBinding
import com.example.beetlestance.benji.ui.BottomNavigationDrawer.BottomNavigationDrawerFragment
import com.example.beetlestance.benji.ui.BottomNavigationDrawer.BottomSettingFragment
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    @Inject
    lateinit var googleSignInClient: GoogleSignInClient

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
        bottom_app_bar.setOnMenuItemClickListener { menuItem ->
            when (menuItem!!.itemId) {
                R.id.app_bar_fav -> Toast.makeText(this, "Fav menu item is clicked!", Toast.LENGTH_SHORT).show()
                R.id.app_bar_search -> Toast.makeText(this, "Search menu item is clicked!", Toast.LENGTH_SHORT).show()
                R.id.action_settings -> displaySettings()
            }
            true
        }
    }

    private fun displaySettings() {
        val bottomSettingFragment = BottomSettingFragment()
        bottomSettingFragment.show(supportFragmentManager, bottomSettingFragment.tag)
    }
}




