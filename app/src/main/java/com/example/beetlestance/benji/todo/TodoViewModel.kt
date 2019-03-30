package com.example.beetlestance.benji.todo

import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.example.beetlestance.benji.repositories.dataLayer.Repositories
import com.example.beetlestance.benji.repositories.model.TodoListData
import com.example.beetlestance.benji.repositories.network.ApiService
import javax.inject.Inject

class TodoViewModel @Inject constructor(retrofitApiService: ApiService): ViewModel() {

    private val repositories = Repositories(retrofitApiService)
    val todoListData = Transformations.map(repositories.todoListData) { data -> convertToUiModel(data) }!!

    private fun convertToUiModel(todoListData: List<TodoListData>): List<TodoListData> {
        return todoListData
    }

    init {
        repositories.loadPost()
    }

    override fun onCleared() {
        super.onCleared()
        repositories.dispose()
    }
}
