package com.andro.control_ladder_game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andro.control_ladder_game.ladder_library.LadderRepository

class MainActivity : AppCompatActivity() {
    val ladderRepository : LadderRepository = LadderRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
}