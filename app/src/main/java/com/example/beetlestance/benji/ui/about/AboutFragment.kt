package com.example.beetlestance.benji.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.beetlestance.benji.R
import com.google.android.material.bottomappbar.BottomAppBar
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_main.*

class AboutFragment : DaggerFragment() {
    companion object {
        const val TAG = "AboutFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.about_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        animateBottomAppBar()
    }

    private fun animateBottomAppBar() {
        activity?.bottom_app_bar?.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
        activity?.fab?.setOnClickListener {
            Toast.makeText(this@AboutFragment.context, TAG, Toast.LENGTH_SHORT).show()
        }
    }
}
