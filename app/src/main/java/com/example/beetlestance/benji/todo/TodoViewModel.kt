package com.example.beetlestance.benji.todo

import android.arch.lifecycle.MutableLiveData
import com.example.beetlestance.benji.base.BaseViewModel
import com.example.beetlestance.benji.network.ApiService
import com.example.beetlestance.benji.model.TodoListData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TodoViewModel : BaseViewModel() {
    @Inject
    lateinit var retrofitApiService: ApiService
    private lateinit var subscription: Disposable
    var todoListData = MutableLiveData<List<TodoListData>>()

    init {
        loadPost()
    }

    private fun loadPost() {

        subscription = retrofitApiService.getNames()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result -> onSuccess(result) }
    }

    private fun onSuccess(todoListData: List<TodoListData>) {
        this.todoListData.value = todoListData
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}
