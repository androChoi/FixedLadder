package com.andro.control_ladder_game

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.andro.control_ladder_game.ladder_library.LadderRepository
import com.andro.control_ladder_game.viewmodels.ShareViewModel

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private val ladderRepository = LadderRepository
    val shareViewModel : ShareViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    fun hihi(){
        Log.i(TAG,"hihi!")
    }
}