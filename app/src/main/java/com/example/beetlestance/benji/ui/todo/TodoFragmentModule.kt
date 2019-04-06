package com.example.beetlestance.benji.ui.todo

import androidx.lifecycle.ViewModel
import com.example.beetlestance.benji.di.modules.viewModelModule.ViewModelKey
import com.example.beetlestance.benji.di.scope.FragmentScoped
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Module where classes needed to create the [TodoFragment] are defined.
 */

@Module
abstract class TodoFragmentModule {

    /**
     * Generates an [AndroidInjector] for the [TodoFragment].
     * With [FragmentScoped]
     */
    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindTodoFragment(): TodoFragment

    /**
     * The ViewModels are created by Dagger in a map. Via the @ViewModelKey, we define that we
     * want to get a [TodoViewModel] class.
     */
    @Binds
    @IntoMap
    @ViewModelKey(TodoViewModel::class)
    abstract fun bindTodoViewModel(todoViewModel: TodoViewModel): ViewModel

}