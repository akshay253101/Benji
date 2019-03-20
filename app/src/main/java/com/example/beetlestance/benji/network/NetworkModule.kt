package com.example.beetlestance.benji.network

import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule{
    /**
     * Single instance is created of Retrofit ApiService through out the Application
     */
    @Provides
    @Singleton
    internal fun retrofitInstanceProvider(): ApiService {
        return NetworkModule().retrofitProvider().create(ApiService::class.java)
    }
    /**
     * Provides single instance of Retrofit
     */
    @Provides
    @Singleton
    internal fun retrofitProvider(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/akshay253101/ContactKotlin/master/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()

    }
}