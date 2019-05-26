package com.example.beetlestance.benji.utils

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Build
import android.os.Build.VERSION_CODES.N
import com.example.beetlestance.benji.constant.Constant
import java.util.*


class LocaleManager {
    companion object {

        private lateinit var prefs: SharedPreferences

        fun setLocale(c: Context): Context {
            return updateBaseContext(c, getLanguage())
        }

        fun setNewLocale(c: Context, language: String): Context {
            persistLanguage(language)
            return updateBaseContext(c, language)
        }

        fun getLanguage(): String? {
            return prefs.getString(Constant.SELECTED_LOCALE, Constant.LOCALE_ENGLISH)
        }

        @SuppressLint("ApplySharedPref")
        private fun persistLanguage(language: String) {
            // use commit() instead of apply(), because sometimes we kill the application process immediately
            // which will prevent apply() to finish
            prefs.edit().putString(Constant.SELECTED_LOCALE, language).commit()
        }

        @JvmStatic
        fun updateBaseContext(context: Context, language: String?): Context {
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

        private fun updateResourcesLocaleLegacy(context: Context, locale: Locale): Context {
            val resources = context.resources
            val configuration = resources.configuration
            configuration.locale = locale
            resources.updateConfiguration(configuration, resources.displayMetrics)
            return context
        }

        fun getLocale(res: Resources): Locale {
            val config = res.configuration
            return if (Utility.isAtLeastVersion(N)) config.locales.get(0) else config.locale
        }

    }
}
