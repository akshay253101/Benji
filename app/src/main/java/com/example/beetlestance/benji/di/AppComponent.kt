package com.example.beetlestance.benji.di

import com.example.beetlestance.benji.MainApplication
import com.example.beetlestance.benji.di.modules.ActivityBindingModule
import com.example.beetlestance.benji.di.modules.AppModule
import com.example.beetlestance.benji.di.modules.networkModule.NetworkModule
import com.example.beetlestance.benji.di.modules.roomDatabaseModule.RoomDatabaseModule
import com.example.beetlestance.benji.di.modules.viewModelModule.ViewModelBindingModule
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
@Component(
    modules = [AndroidSupportInjectionModule::class,
        NetworkModule::class, AppModule::class, ActivityBindingModule::class, ViewModelBindingModule::class,
        RoomDatabaseModule::class]
)
interface AppComponent : AndroidInjector<MainApplication> {
    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<MainApplication>

}