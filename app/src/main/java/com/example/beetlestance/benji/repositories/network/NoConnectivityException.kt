package com.example.beetlestance.benji.repositories.network

import java.io.IOException

class NoConnectivityException : IOException() {

    override fun getLocalizedMessage(): String {
        return "No connectivity exception"
    }
}