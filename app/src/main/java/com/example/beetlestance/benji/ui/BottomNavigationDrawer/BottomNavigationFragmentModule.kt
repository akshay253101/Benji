package com.example.beetlestance.benji.ui.BottomNavigationDrawer

import com.example.beetlestance.benji.di.scope.FragmentScoped
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector

@Module
abstract class BottomNavigationFragmentModule {
    /**
     * Generates an [AndroidInjector] for the [BottomNavigationFragmentModule].
     * With [FragmentScoped]
     */
    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindBottomNavigationDrawerFragment(): BottomNavigationDrawerFragment
}