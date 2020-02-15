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
            }
        }

    override fun onCreate() {
        super.onCreate()

        PreferenceManager(this)
            .sharedPreferences
            .registerOnSharedPreferenceChangeListener(sharedPreferenceChangeListener)
    }
}