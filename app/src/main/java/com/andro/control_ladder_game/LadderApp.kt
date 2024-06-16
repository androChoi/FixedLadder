package com.andro.control_ladder_game

import android.app.Application

class LadderApp : Application() {
    val prefs by lazy { LadderPreference(this) }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: LadderApp
            private set
    }
}