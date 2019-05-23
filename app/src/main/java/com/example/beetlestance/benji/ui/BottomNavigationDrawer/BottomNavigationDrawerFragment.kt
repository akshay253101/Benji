package com.example.beetlestance.benji.ui.bottomNavigationDrawer

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.beetlestance.benji.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.bottom_navigation_fragment.*
import kotlinx.android.synthetic.main.nav_header.view.*

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    lateinit var auth: FirebaseAuth
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        return inflater.inflate(R.layout.bottom_navigation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val header = navigation_view.getHeaderView(0)
        auth = FirebaseAuth.getInstance()
        header.email.text = auth.currentUser!!.email
        Glide.with(this)
            .load(auth.currentUser!!.photoUrl)
            .circleCrop()
            .placeholder(R.drawable.action_contact)
            .into(object : CustomTarget<Drawable>(96, 96) {
                override fun onLoadCleared(placeholder: Drawable?) {
                    header.email.setCompoundDrawablesRelativeWithIntrinsicBounds(placeholder, null, null, null)
                }

                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    header.email.setCompoundDrawablesRelativeWithIntrinsicBounds(resource, null, null, null)
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