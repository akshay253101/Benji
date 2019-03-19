package com.example.beetlestance.benji.component

import com.example.beetlestance.benji.network.NetworkModule
import com.example.beetlestance.benji.todo.TodoViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector{
    /**
     *Injects required dependencies into specified TodoViewModel
     *@param todoViewModel TodoViewModel in whichto inject the dependencies
     */
    fun inject(todoViewModel: TodoViewModel)

    /**
     * Component Builder
     * Add modules and Injector here
     */
    @Component.Builder
    interface Builder{

        fun build():ViewModelInjector

        fun networkModule(networkModule: NetworkModule):Builder
    }
}