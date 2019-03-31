package com.example.beetlestance.benji.di.modules

import android.arch.lifecycle.ViewModel
import com.example.beetlestance.benji.MainActivity
import com.example.beetlestance.benji.di.modules.ViewModelModule.ViewModelKey
import com.example.beetlestance.benji.di.scope.ActivityScoped
import com.example.beetlestance.benji.di.scope.FragmentScoped
import com.example.beetlestance.benji.repositories.dataLayer.Repositories
import com.example.beetlestance.benji.todo.TodoFragment
import com.example.beetlestance.benji.todo.TodoViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class AppBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindTodoFragment(): TodoFragment

    @ContributesAndroidInjector
    abstract fun bindRepositories(): Repositories

    @Binds
    @IntoMap
    @ViewModelKey(TodoViewModel::class)
    abstract fun bindMainViewModel(viewModel: TodoViewModel): ViewModel
}