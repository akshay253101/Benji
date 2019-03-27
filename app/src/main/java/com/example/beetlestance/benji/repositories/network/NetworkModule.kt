package com.example.beetlestance.benji.repositories.network

import com.example.beetlestance.benji.MainApplication
import dagger.Module
import dagger.Provides
import dagger.Reusable
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
    @Singleton
    @Provides
    internal fun retrofitInstanceProvider(): ApiService {
        return NetworkModule().retrofitProvider().create(ApiService::class.java)
    }
    /**
     * Provides single instance of Retrofit
     */
    @Singleton
    @Provides
    internal fun retrofitProvider(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/akshay253101/ContactKotlin/master/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()

    }
}