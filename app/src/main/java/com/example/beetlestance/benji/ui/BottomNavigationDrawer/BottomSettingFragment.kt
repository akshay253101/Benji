package com.example.beetlestance.benji.ui.bottomNavigationDrawer

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.beetlestance.benji.R
import com.example.beetlestance.benji.ui.login.LoginActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.bottom_setting_layout.*

class BottomSettingFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        return inflater.inflate(R.layout.bottom_setting_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navigation_view_settings.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_settings -> Toast.makeText(this.context, "Action Settings", Toast.LENGTH_SHORT).show()
                R.id.action_sign_out -> signOut()
            }
            dismiss()
            true
        }
    }

    private fun signOut() {
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity!!.finish()
    }
}