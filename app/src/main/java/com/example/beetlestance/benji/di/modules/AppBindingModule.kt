package com.example.beetlestance.benji.di.modules

import android.arch.lifecycle.ViewModel
import com.example.beetlestance.benji.MainActivity
import com.example.beetlestance.benji.di.modules.ViewModelFactory.ViewModelKey
import com.example.beetlestance.benji.todo.TodoFragment
import com.example.beetlestance.benji.todo.TodoViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class AppBindingModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindTodoFragment(): TodoFragment

    @Binds
    @IntoMap
    @ViewModelKey(TodoViewModel::class)
    abstract fun bindMainViewModel(viewModel: TodoViewModel): ViewModel
}