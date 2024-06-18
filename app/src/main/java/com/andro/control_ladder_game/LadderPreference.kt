package com.andro.control_ladder_game


import android.content.Context
import android.content.SharedPreferences
import com.andro.control_ladder_game.ladder_library.USER_MAX_LIMIT
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LadderPreference(private val context: Context) {
    private val prefs =
        context.getSharedPreferences("LadderPreference", Context.MODE_PRIVATE)
    private val gson = Gson()

    var playCount : Int
        get() = prefs.getInt("playCount", 0)
        set(value) = prefs.edit().putInt("playCount", value).apply()

    var gameSpeed : Int
        get() = prefs.getInt("gameSpeed", 1)
        set(value) = prefs.edit().putInt("gameSpeed", value).apply()

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
                List(USER_MAX_LIMIT + 1){_ ->
                    -1
                }
            }
        }
        set(value) {
            val json = gson.toJson(value)
            prefs.edit().putString("boomerKingList", json).apply()
        }

    var probabilityList: String
        get() = prefs.getString("probabilityList", makeDefault())!!
        set(value) = prefs.edit().putString("probabilityList", value).apply()

    private fun makeDefault(): String{
        var s = ""

        repeat(100){
            s += "-1,"
        }

        return s.substring(0 until s.length-1)
    }
}

data class ProbabilityList(val idx : Int, val list : List<Int>)