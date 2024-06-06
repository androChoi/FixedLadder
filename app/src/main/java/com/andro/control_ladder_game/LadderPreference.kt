package com.andro.control_ladder_game

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class LadderPreference(private val context: Context) {
    private val prefs =
        context.getSharedPreferences("LadderPreference", Context.MODE_PRIVATE)



    var cheatingResult: Int
        get() = prefs.getInt("cheatingMode", -1)
        set(value) = prefs.edit().putInt("cheatingMode", value).apply()
}