package com.example.darkmode

import androidx.appcompat.app.AppCompatDelegate

object DarkMode {

    /** Always Dark mode */
    const val CONFIG_ALWAYS = 1

    /** Never Dark mode */
    const val CONFIG_NEVER = 2

    /** Dark mode only when system wide dark mode is enabled */
    const val CONFIG_SYSTEM_WIDE = 3


    fun setConfig(config: Int) {
        when (config) {
            CONFIG_ALWAYS -> setMode(AppCompatDelegate.MODE_NIGHT_YES)
            CONFIG_NEVER -> setMode(AppCompatDelegate.MODE_NIGHT_NO)
            CONFIG_SYSTEM_WIDE -> setMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }


    private fun setMode(mode: Int) {
        AppCompatDelegate.setDefaultNightMode(mode)
    }
}