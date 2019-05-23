package com.example.beetlestance.benji.ui.about

import com.example.beetlestance.benji.di.scope.FragmentScoped
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector

@Module
abstract class AboutFragmentModule {

    /**
     * Generates an [AndroidInjector] for the [AboutFragment].
     * With [FragmentScoped]
     */

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindAboutFragment(): AboutFragment
}