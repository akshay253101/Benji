package com.example.beetlestance.benji.di

import com.example.beetlestance.benji.MainApplication
import com.example.beetlestance.benji.di.modules.AppBindingModule
import com.example.beetlestance.benji.di.modules.AppModule
import com.example.beetlestance.benji.di.modules.NetworkModule
import com.example.beetlestance.benji.di.modules.ViewModelModule.ViewModelBindingModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class, AppModule::class, AppBindingModule::class, ViewModelBindingModule::class])
interface AppComponent : AndroidInjector<MainApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MainApplication>()

}