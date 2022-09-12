package com.music.activity

import android.app.Application
import com.music.activity.utilSharePreferenes.PreferencesManager

class App:Application() {
    lateinit var preferencesManager:PreferencesManager
    override fun onCreate() {
        super.onCreate()
        preferencesManager = PreferencesManager(this)
    }
}