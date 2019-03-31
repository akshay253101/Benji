package com.example.beetlestance.benji.todo

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.beetlestance.benji.repositories.dataLayer.Repositories
import com.example.beetlestance.benji.repositories.model.TodoListData
import javax.inject.Inject

class TodoViewModel @Inject constructor(var repositories : Repositories) : ViewModel() {

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
