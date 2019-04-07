package com.example.beetlestance.benji.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.beetlestance.benji.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_navigation_fragment.*

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_navigation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.up_from_bottom)
            .setExitAnim(R.anim.slide_out_right)
            .build()
        val navController = findNavController()
        navigation_view.setNavigationItemSelectedListener { menuItem ->
            if (menuItem.itemId != navController.currentDestination!!.id) {
                navController.navigate(menuItem.itemId,null,navOptions)
               // menuItem.onNavDestinationSelected(navController)
            }
            menuItem.isChecked = true
            dismiss()
            true
        }
    }
}