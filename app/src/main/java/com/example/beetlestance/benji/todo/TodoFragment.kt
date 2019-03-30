package com.example.beetlestance.benji.todo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.beetlestance.benji.R
import com.example.beetlestance.benji.databinding.TodoFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TodoFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory
    private lateinit var binding: TodoFragmentBinding
    private lateinit var viewModel: TodoViewModel
    private val todoListAdapter = TodoListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.todo_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.layoutManager = LinearLayoutManager(context)
        binding.adapter = todoListAdapter
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(TodoViewModel::class.java)
        viewModel.todoListData.observe(
            this,
            Observer { todoListData -> if (todoListData != null) todoListAdapter.updateToDoList(todoListData) })
    }

}