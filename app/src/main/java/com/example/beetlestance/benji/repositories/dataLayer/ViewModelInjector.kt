package com.example.beetlestance.benji.repositories.dataLayer

import com.example.beetlestance.benji.MainActivityViewModel
import com.example.beetlestance.benji.repositories.network.NetworkModule
import com.example.beetlestance.benji.todo.TodoViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ViewModelInjector{

    fun inject(todoViewModel: TodoViewModel)

    fun inject(mainActivityViewModel: MainActivityViewModel)

    @Component.Builder
    interface Builder{
        fun build() : ViewModelInjector

        fun networkModule(networkModule: NetworkModule):Builder
    }

}