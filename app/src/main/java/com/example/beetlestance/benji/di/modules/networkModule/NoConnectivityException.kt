package com.example.beetlestance.benji.di.modules.networkModule

import com.example.beetlestance.benji.constant.Constant.NO_CONNECTIVITY_EXCEPTION
import java.io.IOException

class NoConnectivityException : IOException() {

    override fun getLocalizedMessage(): String {
        return NO_CONNECTIVITY_EXCEPTION
    }
}