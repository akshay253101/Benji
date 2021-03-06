package com.example.beetlestance.benji.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.example.beetlestance.benji.MainApplication
import com.example.beetlestance.benji.constant.Constant.APPLICATION_CONTEXT
import com.example.beetlestance.benji.constant.Constant.SHARED_PREFERENCE_NAME
import com.google.firebase.analytics.FirebaseAnalytics
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

    @Named(APPLICATION_CONTEXT)
    @Provides
    fun provideContext(mainApplication: MainApplication): Context {
        return mainApplication.applicationContext
    }

    /*
    * Provides Shared Preference
    */
    @Provides
    fun provideSharedPreference(mainApplication: MainApplication): SharedPreferences {
        return mainApplication.applicationContext.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    /*
    * Provides Shared Preference Editor
    */
    @Provides
    fun provideSharedPreferenceEditor(mainApplication: MainApplication): SharedPreferences.Editor {
        return mainApplication.applicationContext.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)
            .edit()
    }

    /*
    * Provides Firebase Analytics
    */
    @Provides
    fun provideFirebaseAnalytics(mainApplication: MainApplication): FirebaseAnalytics {
        return FirebaseAnalytics.getInstance(mainApplication)
    }
}