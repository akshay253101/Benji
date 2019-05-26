package com.example.beetlestance.benji.utils

import android.os.Build


class Utility {
    companion object {
        fun isAtLeastVersion(version: Int): Boolean {
            return Build.VERSION.SDK_INT >= version
        }
    }
}
