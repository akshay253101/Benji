package com.example.beetlestance.benji.repositories.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import com.example.beetlestance.benji.di.modules.AppModule
import dagger.Module
import dagger.Provides
import java.util.Objects
import javax.inject.Named

@Module(includes = [AppModule::class])
class ConnectionCheck {

    @Named("isOnline")
    @Provides
    fun isOnline(@Named("AppContext")context: Context): Boolean {
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
