package com.example.beetlestance.benji.ui.bottomNavigationDrawer

import com.example.beetlestance.benji.di.scope.FragmentScoped
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector

@Module
abstract class BottomSettingFragmentModule {
    /**
     * Generates an [AndroidInjector] for the [BottomSettingFragmentModule].
     * With [FragmentScoped]
     */
    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindBottomSettingFragment(): BottomSettingFragment
}
