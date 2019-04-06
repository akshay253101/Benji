package com.example.beetlestance.benji.domain

import com.example.beetlestance.benji.model.TodoListData
import io.reactivex.Observable
import retrofit2.http.GET

/*
* All network calls will be defined here
**/

interface ApiService {
    @GET("data.json")
    fun getNames(): Observable<List<TodoListData>>
}