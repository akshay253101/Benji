package com.example.beetlestance.benji.utils

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Build
import android.os.Build.VERSION_CODES.N
import com.example.beetlestance.benji.constant.Constant.LOCALE_ENGLISH
import com.example.beetlestance.benji.constant.Constant.SELECTED_LOCALE
import com.example.beetlestance.benji.constant.Constant.SHARED_PREFERENCE_NAME
import com.example.beetlestance.benji.utils.Utility.Companion.isAtLeastVersion
import java.util.*


object LocaleManager {

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun setLocale(c: Context): Context {
        return updateBaseContext(c, getLanguage(c))
    }

    fun setNewLocale(c: Context, language: String): Context {
        persistLanguage(c, language)
        return updateBaseContext(c, language)
    }

    fun isEnglishLocale(context: Context): Boolean {
        if (getLocale(context.resources).language == LOCALE_ENGLISH) {
            return true
        }
        return false
    }

    fun getLanguage(context: Context): String {
        return getPrefs(context).getString(SELECTED_LOCALE, LOCALE_ENGLISH) ?: LOCALE_ENGLISH
    }

    @Suppress("DEPRECATION")
    fun getLocale(res: Resources): Locale {
        val config = res.configuration
        return if (isAtLeastVersion(N)) config.locales.get(0) else config.locale
    }

    @SuppressLint("ApplySharedPref")
    private fun persistLanguage(context: Context, language: String) {
        // use commit() instead of apply(), because sometimes we kill the application process immediately
        // which will prevent apply() to finish
        getPrefs(context).edit().putString(SELECTED_LOCALE, language).commit()
    }


    @JvmStatic
    private fun updateBaseContext(context: Context, language: String): Context {
        val locale = Locale(language)

        if (Build.VERSION.SDK_INT >= N) {
            return updateResourcesLocale(context, locale)
        }
        return updateResourcesLocaleLegacy(context, locale)
    }

    @TargetApi(N)
    private fun updateResourcesLocale(context: Context, locale: Locale): Context {
        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        return context.createConfigurationContext(configuration)
    }

    @Suppress("DEPRECATION")
    private fun updateResourcesLocaleLegacy(context: Context, locale: Locale): Context {
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        resources.updateConfiguration(configuration, resources.displayMetrics)
        return context
    }
}

