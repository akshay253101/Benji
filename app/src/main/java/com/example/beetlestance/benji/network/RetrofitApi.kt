package com.example.beetlestance.benji.network

import com.example.beetlestance.benji.model.ApiService
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitApi {

    fun retrofitInstanceProvider(): ApiService {
        return RetrofitApi().retrofitProvider().create(ApiService::class.java)
    }

    private fun retrofitProvider(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/akshay253101/ContactKotlin/master/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()

    }
}