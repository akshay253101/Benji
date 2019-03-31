package com.example.beetlestance.benji.di.modules.viewModelModule

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Module used to define the connection between the framework's [ViewModelProvider.Factory] and
 * our own implementation: [DaggerAwareViewModelFactory].
 */

@Module
abstract class ViewModelBindingModule {
    @Binds
    abstract fun bindViewModelFactory(factory: DaggerAwareViewModelFactory):
            ViewModelProvider.Factory
}