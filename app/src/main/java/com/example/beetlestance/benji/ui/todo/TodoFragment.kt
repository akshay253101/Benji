package com.example.beetlestance.benji.ui.todo

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.beetlestance.benji.databinding.TodoFragmentBinding
import com.example.beetlestance.benji.model.TodoListData
import com.google.android.material.bottomappbar.BottomAppBar
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.todo_fragment.*
import javax.inject.Inject

class TodoFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: TodoFragmentBinding
    private lateinit var viewModel: TodoViewModel
    private val todoListAdapter = TodoListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        postponeEnterTransition()
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
            Observer { todoListData -> hideProgressBar(todoListData) })
    }

    private fun animateBottomAppBar() {
        activity?.bottom_app_bar?.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        activity?.fab?.setOnClickListener {
            todoListAdapter.notifyDataSetChanged()
            Toast.makeText(this@TodoFragment.context, "Todo Fragment", Toast.LENGTH_SHORT).show()
        }
    }

    private fun hideProgressBar(todoListData: List<TodoListData>) {
        progressBar.hide()
        todoListAdapter.updateToDoList(todoListData = todoListData)
        startPostponedEnterTransition()
        animateBottomAppBar()
    }
}