package com.example.beetlestance.benji.di.modules

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.example.beetlestance.benji.MainApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideContext(mainApplication: MainApplication): Context {
        return mainApplication.applicationContext
    }
}