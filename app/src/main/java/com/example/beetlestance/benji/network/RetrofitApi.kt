package com.example.beetlestance.benji.network

import com.example.beetlestance.benji.model.ApiService
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class RetrofitApi{
    @Provides
    @Singleton
    internal fun retrofitInstanceProvider(): ApiService {
        return RetrofitApi().retrofitProvider().create(ApiService::class.java)
    }
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