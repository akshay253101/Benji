package com.example.beetlestance.benji.repositories.dataLayer

import com.example.beetlestance.benji.MainApplication
import com.example.beetlestance.benji.repositories.network.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,NetworkModule::class])
interface AppComponent : AndroidInjector<MainApplication>{
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MainApplication>()

}