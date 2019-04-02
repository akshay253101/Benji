package com.example.beetlestance.benji.di.modules

import androidx.annotation.NonNull
import com.example.beetlestance.benji.MainApplication
import com.example.beetlestance.benji.repositories.network.ApiService
import com.example.beetlestance.benji.repositories.network.ConnectionCheck
import com.example.beetlestance.benji.repositories.network.ConnectionCheck.isOnline
import com.example.beetlestance.benji.repositories.network.NoConnectivityException
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Defines all the network classes that need to be provided in the scope of the app.
 *
 * Define here all objects that are shared throughout the app, like [retrofitInstanceProvider].
 * If some of those objects are singletons, they should be annotated with `@Singleton`.
 */
@Module
class NetworkModule : Interceptor {

    /**
     * Single instance is created of Retrofit ApiService through out the Application
     */
    @Singleton
    @Provides
    fun retrofitInstanceProvider(): ApiService {
        return retrofitProvider().create(ApiService::class.java)
    }

    /**
     * Provides single instance of Retrofit
     */
    @Singleton
    @Provides
    fun retrofitProvider(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/akshay253101/ContactKotlin/master/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(okHttpClient())
            .build()

    }

    private val Cache_Control = "cache-control"

    private fun okHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(provideHttpLoggingInterceptor())
            .addInterceptor(provideOfflineCacheInterceptor())
            .addNetworkInterceptor(provideCacheInterceptor())
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .cache(provideCache())
            .build()
    }

    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor {}
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return httpLoggingInterceptor
    }

    private fun provideOfflineCacheInterceptor() = Interceptor { chain ->
        var request = chain.request()
        request = if (ConnectionCheck.isOnline(MainApplication.getContext())) {
            val cacheControl = CacheControl.Builder().maxStale(7, TimeUnit.DAYS).build()
            request.newBuilder().cacheControl(cacheControl).build()
        } else {
            val cacheHeaderValue = if (isOnline(MainApplication.getContext()))
                "public, max-age=2419200"
            else
                "public, only-if-cached, max-stale=2419200"
            request.newBuilder().header("Cache-Control", cacheHeaderValue)
                .build()
        }
        chain.proceed(request)
    }

    private fun provideCacheInterceptor() = Interceptor { chain ->
        val response = chain.proceed(chain.request())
        val cacheControl = CacheControl.Builder().maxStale(2, TimeUnit.DAYS).build()

        response.newBuilder().removeHeader("Pragma").header(Cache_Control, cacheControl.toString()).build()
    }

    private fun provideCache(): Cache? {
        var cache: Cache? = null
        try {
            cache = Cache(File(MainApplication.getContext().cacheDir, "http-cache"), (10 * 1024 * 1024).toLong())

        } catch (e: Exception) {
            println("Error " + e.message)
        }
        return cache
    }


    @Throws(IOException::class)
    override fun intercept(@NonNull chain: Interceptor.Chain): Response {
        if (!ConnectionCheck.isOnline(MainApplication.getContext())) {
            throw NoConnectivityException()
        }
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }
}
