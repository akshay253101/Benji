package com.example.beetlestance.benji

import android.content.Context
import dagger.android.support.DaggerAppCompatActivity

open class BaseActivity :DaggerAppCompatActivity(){
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
    }
}