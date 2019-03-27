package com.example.beetlestance.benji.base

import android.arch.lifecycle.ViewModel
import com.example.beetlestance.benji.MainActivityViewModel
import com.example.beetlestance.benji.repositories.dataLayer.DaggerViewModelInjector
import com.example.beetlestance.benji.repositories.dataLayer.ViewModelInjector
import com.example.beetlestance.benji.repositories.network.NetworkModule
import com.example.beetlestance.benji.todo.TodoViewModel

abstract class BaseViewModel : ViewModel(){

    private val injector:ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule())
        .build()

    init {
        inject()
    }

    private fun inject(){
        when(this){
            is TodoViewModel -> injector.inject(this)
            is MainActivityViewModel -> injector.inject(this)
        }
    }

}