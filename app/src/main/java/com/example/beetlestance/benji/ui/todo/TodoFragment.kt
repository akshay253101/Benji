package com.example.beetlestance.benji.ui.todo

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.ViewGroup
import com.example.beetlestance.benji.databinding.TodoFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TodoFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: TodoFragmentBinding
    private lateinit var viewModel: TodoViewModel
    private val todoListAdapter = TodoListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = TodoFragmentBinding.inflate(inflater, container, false).apply { lifecycleOwner = this@TodoFragment }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.layoutManager = LinearLayoutManager(context)
        binding.adapter = todoListAdapter

        viewModel = ViewModelProviders.of(this@TodoFragment, viewModelFactory).get(TodoViewModel::class.java)
        viewModel.todoListData.observe(
            this@TodoFragment,
            Observer { todoListData -> if (todoListData != null) todoListAdapter.updateToDoList(todoListData) })
    }

}