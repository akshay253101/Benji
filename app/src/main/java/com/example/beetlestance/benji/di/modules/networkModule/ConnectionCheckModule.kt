package com.example.beetlestance.benji.di.modules.networkModule

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import com.example.beetlestance.benji.constant.Constant.APPLICATION_CONTEXT
import com.example.beetlestance.benji.constant.Constant.IS_ONLINE
import com.example.beetlestance.benji.di.modules.AppModule
import dagger.Module
import dagger.Provides
import java.util.Objects
import javax.inject.Named

/**
* ConnectionCheckModule provides isUserOnline or not.
*/

@Module(includes = [AppModule::class])
class ConnectionCheckModule {

    @Named(IS_ONLINE)
    @Provides
    fun isOnline(@Named(APPLICATION_CONTEXT)context: Context): Boolean {
        val connectivityManager: ConnectivityManager
        var networkInfo: NetworkInfo? = null

        try {
            connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            networkInfo = Objects.requireNonNull(connectivityManager).activeNetworkInfo
        } catch (e: Exception) {
            Log.e("connectivity", e.toString())
        }

        return networkInfo != null && networkInfo.isConnected

    }

}
