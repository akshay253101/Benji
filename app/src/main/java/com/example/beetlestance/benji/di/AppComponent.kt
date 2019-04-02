package com.example.beetlestance.benji.di

import com.example.beetlestance.benji.MainApplication
import com.example.beetlestance.benji.di.modules.AppBindingModule
import com.example.beetlestance.benji.di.modules.AppModule
import com.example.beetlestance.benji.di.modules.NetworkModule
import com.example.beetlestance.benji.di.modules.viewModelModule.ViewModelBindingModule
import com.example.beetlestance.benji.repositories.network.ConnectionCheck
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Main component of the app, created and persisted in the Application class.
 *
 * Whenever a new module is created, it should be added to the list of modules.
 * [AndroidSupportInjectionModule] is the module from Dagger.Android that helps with the
 * generation and location of SubComponents.
 */

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class, AppModule::class, AppBindingModule::class, ViewModelBindingModule::class])
interface AppComponent : AndroidInjector<MainApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MainApplication>()

}