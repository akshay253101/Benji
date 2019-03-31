package com.example.beetlestance.benji.di.modules

import androidx.lifecycle.ViewModel
import com.example.beetlestance.benji.MainActivity
import com.example.beetlestance.benji.di.AppComponent
import com.example.beetlestance.benji.di.modules.viewModelModule.ViewModelKey
import com.example.beetlestance.benji.di.scope.ActivityScoped
import com.example.beetlestance.benji.di.scope.FragmentScoped
import com.example.beetlestance.benji.repositories.dataLayer.Repositories
import com.example.beetlestance.benji.todo.TodoFragment
import com.example.beetlestance.benji.todo.TodoViewModel
import dagger.Binds
import dagger.android.AndroidInjector
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * We want Dagger.Android to create a SubComponent which has a parent Component of whichever module
 * ActivityBindingModule is on, in our case that will be [AppComponent]. You never
 * need to tell [AppComponent] that it is going to have all these SubComponents
 * nor do you need to tell these SubComponents that [AppComponent] exists.
 * We are also telling Dagger.Android that this generated SubComponent needs to include the
 * specified modules and be aware of a scope annotation [ActivityScoped].
 * When Dagger.Android annotation processor runs it will create 2 SubComponents for us.
 */

@Module
abstract class AppBindingModule {

    /**
     * Generates an [AndroidInjector] for the [MainActivity].
     * With [ActivityScoped]
     */
    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

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
    abstract fun bindTodoViewModel(viewModel: TodoViewModel): ViewModel
}