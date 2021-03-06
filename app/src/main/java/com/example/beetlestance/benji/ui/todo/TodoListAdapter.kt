package com.example.beetlestance.benji.ui.todo

import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.example.beetlestance.benji.R
import com.example.beetlestance.benji.databinding.TodoListItemBinding
import com.example.beetlestance.benji.model.TodoListData

class TodoListAdapter : RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {

    private lateinit var todoList: List<TodoListData>

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val binding: TodoListItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.todo_list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::todoList.isInitialized) todoList.size else 0
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(todoList[position])
    }

    fun updateToDoList(todoListData: List<TodoListData>) {
        this.todoList = todoListData
        notifyDataSetChanged()
    }

    class ViewHolder(private val itemBinding: TodoListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(todoListData: TodoListData) {
            itemBinding.todoListData = todoListData
            itemBinding.executePendingBindings()
        }
    }
}