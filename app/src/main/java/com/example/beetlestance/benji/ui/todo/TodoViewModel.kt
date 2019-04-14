package com.example.beetlestance.benji.ui.todo

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.beetlestance.benji.domain.TodoUseCase
import com.example.beetlestance.benji.model.TodoListData
import javax.inject.Inject

class TodoViewModel @Inject constructor(var todoUseCase: TodoUseCase) : ViewModel() {

    var todoListData = Transformations.map(todoUseCase()){ data -> convertModel(data)}

    private fun convertModel(todoListData: List<TodoListData>): List<TodoListData> {
        return todoListData
    }


    override fun onCleared() {
        super.onCleared()
        todoUseCase.onDispose()
    }
}