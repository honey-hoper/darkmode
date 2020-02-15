package com.example.darkmode

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager

class App : Application() {

    private val sharedPreferenceChangeListener =
        SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            Log.d("APP", "Called")
            Log.d("APP", key)

            if (key == "dark_mode") {
                val bool = sharedPreferences.getBoolean(key, false)
                Log.d("APP", sharedPreferences.getBoolean(key, false).toString())
                if (bool) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

    override fun onCreate() {
        super.onCreate()

        val bool = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("dark_mode", false)
        if (bool) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        PreferenceManager(this)
            .sharedPreferences
            .registerOnSharedPreferenceChangeListener(sharedPreferenceChangeListener)
    }
}