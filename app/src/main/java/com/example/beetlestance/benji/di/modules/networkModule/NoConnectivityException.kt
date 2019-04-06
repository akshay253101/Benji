package com.example.beetlestance.benji.di.modules.networkModule

import java.io.IOException

class NoConnectivityException : IOException() {

    override fun getLocalizedMessage(): String {
        return "No connectivity exception"
    }
}