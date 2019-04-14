package com.example.beetlestance.benji.ui.BottomNavigationDrawer

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.beetlestance.benji.R
import com.example.beetlestance.benji.constant.Constant.CURRENT_USER
import com.example.beetlestance.benji.constant.Constant.SHARED_PREFERENCE_NAME
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.bottom_navigation_fragment.*
import kotlinx.android.synthetic.main.nav_header.view.*
import javax.inject.Inject

class BottomNavigationDrawerFragment : BottomSheetDialogFragment(), HasSupportFragmentInjector {

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        return inflater.inflate(R.layout.bottom_navigation_fragment, container, false)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return childFragmentInjector
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val header = navigation_view.getHeaderView(0)
        header.email.text = sharedPreferences.getString(CURRENT_USER, "")
        val navController = findNavController()
        navigation_view.setNavigationItemSelectedListener { menuItem ->
            if (menuItem.itemId != navController.currentDestination!!.id) {
                navController.navigate(menuItem.itemId)
            }
            dismiss()
            true
        }
    }
}