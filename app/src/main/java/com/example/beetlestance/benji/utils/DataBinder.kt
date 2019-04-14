package com.example.beetlestance.benji.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beetlestance.benji.ui.todo.TodoListAdapter

/**
 *@param todoListAdapter is the TodoListAdapter to be attached to RecyclerView
 */
@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, todoListAdapter: TodoListAdapter) {
    view.adapter = todoListAdapter
}

/**
 *@param linearLayoutManager is the LinearLayoutManager to be attached to RecyclerView
 */
@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, linearLayoutManager: LinearLayoutManager) {
    view.layoutManager = linearLayoutManager
}

