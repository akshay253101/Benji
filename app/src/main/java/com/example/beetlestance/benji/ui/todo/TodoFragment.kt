package com.example.beetlestance.benji.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beetlestance.benji.databinding.TodoFragmentBinding
import com.example.beetlestance.benji.model.TodoListData
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.todo_fragment.*
import javax.inject.Inject

class TodoFragment : DaggerFragment() {
    companion object {
        const val TAG = "TodoFragment"
    }

    @Inject
    lateinit var firebaseAnalytics: FirebaseAnalytics
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
        firebaseAnalytics.logEvent(TAG,null)
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