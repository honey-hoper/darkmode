package com.example.darkmode

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager

class App : Application() {

    private val sharedPreferenceChangeListener =
        SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            if (key == "dark_mode")
                DarkMode.setConfig(getDarkModePreference())
        }

    override fun onCreate() {
        super.onCreate()

        DarkMode.setConfig(getDarkModePreference())

        PreferenceManager(this)
            .sharedPreferences
            .registerOnSharedPreferenceChangeListener(sharedPreferenceChangeListener)
    }


    private fun getDarkModePreference(): Int {
        val value = PreferenceManager
            .getDefaultSharedPreferences(this)
            .getString("dark_mode", DarkMode.CONFIG_NEVER.toString())!!
        return value.toInt()
    }
}