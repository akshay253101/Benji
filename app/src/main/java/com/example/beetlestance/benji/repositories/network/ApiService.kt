package com.example.beetlestance.benji.repositories.network

import com.example.beetlestance.benji.repositories.model.TodoListData
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("data.json")
    fun getNames(): Observable<List<TodoListData>>
}