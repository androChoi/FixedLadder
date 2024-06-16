package com.andro.control_ladder_game


import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LadderPreference(private val context: Context) {
    private val prefs =
        context.getSharedPreferences("LadderPreference", Context.MODE_PRIVATE)
    private val gson = Gson()

    var playCount : Int
        get() = prefs.getInt("playCount", 0)
        set(value) = prefs.edit().putInt("playCount", value).apply()

    var cheatingResult: Int
        get() = prefs.getInt("cheatingMode", -1)
        set(value) = prefs.edit().putInt("cheatingMode", value).apply()


    var boomerKing: Int
        get() = prefs.getInt("boomerKing", -1)
        set(value) = prefs.edit().putInt("boomerKing", value).apply()


    var boomerKingList: List<Int>
        get() {
            val json = prefs.getString("boomerKingList", null)
            return if (json != null) {
                gson.fromJson(json,  object : TypeToken<List<Int>>() {}.type)
            } else {
                emptyList()
            }
        }
        set(value) {
            val json = gson.toJson(value)
            prefs.edit().putString("boomerKingList", json).apply()
        }

    var probabilityList: List<List<Int>>
        get() {
            val json = prefs.getString("probabilityList", null)
            return if (json != null) {
                gson.fromJson(json, object : TypeToken<List<List<Int>>>(){}.type)
            } else {
                emptyList()
            }
        }
        set(value) {
            val json = gson.toJson(value)
            prefs.edit().putString("probabilityList", json).apply()
        }
}