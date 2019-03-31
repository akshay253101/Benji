package com.example.beetlestance.benji.di.modules

import com.example.beetlestance.benji.repositories.network.ApiService
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Defines all the network classes that need to be provided in the scope of the app.
 *
 * Define here all objects that are shared throughout the app, like [retrofitInstanceProvider].
 * If some of those objects are singletons, they should be annotated with `@Singleton`.
 */
@Module
class NetworkModule {
    /**
     * Single instance is created of Retrofit ApiService through out the Application
     */
    @Singleton
    @Provides
    fun retrofitInstanceProvider(): ApiService {
        return NetworkModule()
            .retrofitProvider().create(ApiService::class.java)
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
            .build()

    }
}