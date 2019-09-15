package com.example.beetlestance.benji.di.modules.networkModule

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import com.example.beetlestance.benji.constant.Constant.APPLICATION_CONTEXT
import com.example.beetlestance.benji.constant.Constant.IS_ONLINE
import com.example.beetlestance.benji.di.modules.AppModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * ConnectionCheckModule provides isUserOnline or not.
 */

@Module(includes = [AppModule::class])
class ConnectionCheckModule {

    @Named(IS_ONLINE)
    @Provides
    fun isOnline(@Named(APPLICATION_CONTEXT) context: Context): Boolean {
        val connectivityManager: ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val builder = NetworkRequest.Builder()
        var isOnline = false

        connectivityManager.registerNetworkCallback(
            builder.build(),
            object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    isOnline = true
                }

                override fun onLost(network: Network) {
                    isOnline = false
                }

                override fun onUnavailable() {
                    isOnline = false
                }
            }
        )

        return isOnline

    }

}
