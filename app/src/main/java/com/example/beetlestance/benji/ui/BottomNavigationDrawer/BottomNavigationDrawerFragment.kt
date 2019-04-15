package com.example.beetlestance.benji.ui.bottomNavigationDrawer

import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.beetlestance.benji.R
import com.example.beetlestance.benji.constant.Constant.CURRENT_USER
import com.example.beetlestance.benji.constant.Constant.CURRENT_USER_PROFILE
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.bottom_navigation_fragment.*
import kotlinx.android.synthetic.main.nav_header.view.*
import javax.inject.Inject

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        return inflater.inflate(R.layout.bottom_navigation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val header = navigation_view.getHeaderView(0)
        header.email.text = sharedPreferences.getString(CURRENT_USER, "")
        Glide.with(this)
            .load(Uri.parse(sharedPreferences.getString(CURRENT_USER_PROFILE,"")))
            .circleCrop()
            .placeholder(R.drawable.action_contact)
            .into(object: CustomTarget<Drawable>(96,96) {
                override fun onLoadCleared(placeholder: Drawable?) {
                    header.email.setCompoundDrawablesRelativeWithIntrinsicBounds(placeholder,null,null, null)
                }

                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    header.email.setCompoundDrawablesRelativeWithIntrinsicBounds(resource,null,null, null)
                }
            })

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