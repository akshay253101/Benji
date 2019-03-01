package com.example.beetlestance.benji.model

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("data.json")
    fun getNames(): Observable<List<TodoListData>>
}