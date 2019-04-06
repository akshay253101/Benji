package com.example.beetlestance.benji.di.modules.viewModelModule

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
* [ViewModelBindingModule] is a module to provide ViewModelFactory which is dagger aware
*/
@Module
abstract class ViewModelBindingModule {
    @Binds
    abstract fun bindViewModelFactory(factory: DaggerAwareViewModelFactory):
            ViewModelProvider.Factory
}