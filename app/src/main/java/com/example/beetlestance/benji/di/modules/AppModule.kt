package com.example.beetlestance.benji.di.modules

import android.content.Context
import com.example.beetlestance.benji.MainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Defines all the classes that need to be provided in the scope of the app.
 *
 * Define here all objects that are shared throughout the app, like SharedPreferences, navigators or
 * others. If some of those objects are singletons, they should be annotated with `@Singleton`.
 */

@Module
class AppModule {

    /**
     * Provide Application Context
     */

    @Named("AppContext")
    @Provides
    fun provideContext(mainApplication: MainApplication): Context {
        return mainApplication.applicationContext
    }
}