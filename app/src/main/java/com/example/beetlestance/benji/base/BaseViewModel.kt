package com.example.beetlestance.benji.base

import android.arch.lifecycle.ViewModel
import com.example.beetlestance.benji.MainActivityViewModel
import com.example.beetlestance.benji.component.DaggerViewModelInjector
import com.example.beetlestance.benji.component.ViewModelInjector
import com.example.beetlestance.benji.repositories.network.NetworkModule
import com.example.beetlestance.benji.todo.TodoViewModel

/**
 * BaseViewModel all ViewModel must extend BaseViewModel
 *
 */
abstract class BaseViewModel:ViewModel(){
    /**
     * ViewModelInjector
     */
    private val injector : ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule())
        .build()

    init {
        inject()
    }

    /**
     * All ViewModel which requires dependency injection must inject here
     */
    private fun inject(){
        when (this) {
            is TodoViewModel -> injector.inject(this)
            is MainActivityViewModel -> injector.inject(this)
        }
    }
}