package com.example.beetlestance.benji.di.modules

import com.example.beetlestance.benji.MainActivity
import com.example.beetlestance.benji.di.AppComponent
import com.example.beetlestance.benji.di.scope.ActivityScoped
import com.example.beetlestance.benji.ui.todo.TodoFragmentModule
import dagger.android.AndroidInjector
import dagger.Module
import dagger.android.ContributesAndroidInjector

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
abstract class ActivityBindingModule {

    /**
     * Generates an [AndroidInjector] for the [MainActivity].
     * With [ActivityScoped]
     */
    @ActivityScoped
    @ContributesAndroidInjector(modules = [TodoFragmentModule::class])
    abstract fun bindMainActivity(): MainActivity

}