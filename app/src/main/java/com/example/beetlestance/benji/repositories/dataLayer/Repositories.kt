package com.example.beetlestance.benji.repositories.dataLayer

import android.arch.lifecycle.MutableLiveData
import com.example.beetlestance.benji.repositories.model.TodoListData
import com.example.beetlestance.benji.repositories.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class Repositories(private var retrofitApiService: ApiService){

    private lateinit var subscription: Disposable
    var todoListData = MutableLiveData<List<TodoListData>>()

    fun loadPost(){
        subscription = retrofitApiService.getNames()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result -> todoListData.value = result }
    }

    fun dispose(){
        subscription.dispose()
    }
}