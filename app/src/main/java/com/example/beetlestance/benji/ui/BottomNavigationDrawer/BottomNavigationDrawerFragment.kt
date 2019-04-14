package com.example.beetlestance.benji.ui.BottomNavigationDrawer

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.beetlestance.benji.R
import com.example.beetlestance.benji.constant.Constant.CURRENT_USER
import com.example.beetlestance.benji.constant.Constant.SHARED_PREFERENCE_NAME
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_navigation_fragment.*
import kotlinx.android.synthetic.main.nav_header.view.*

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_navigation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val preference = context!!.getSharedPreferences(SHARED_PREFERENCE_NAME,Context.MODE_PRIVATE)
        val header = navigation_view.getHeaderView(0)
        header.email.text = preference.getString(CURRENT_USER,"")
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