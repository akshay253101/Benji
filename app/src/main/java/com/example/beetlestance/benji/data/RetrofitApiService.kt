package com.example.beetlestance.benji.data

import com.example.beetlestance.benji.constant.Constant.TODO_LIST_ENDPOINT
import com.example.beetlestance.benji.model.TodoListData
import io.reactivex.Observable
import retrofit2.http.GET

/*
* All network calls will be defined here
**/
interface RetrofitApiService {

    @GET(TODO_LIST_ENDPOINT)
    fun getNames(): Observable<List<TodoListData>>

}