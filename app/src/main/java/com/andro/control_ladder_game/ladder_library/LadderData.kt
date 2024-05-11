package com.andro.control_ladder_game.ladder_library

import android.media.Image
import android.util.Log

data class HorseData(val userPhoto : Image, val userName : String, private var row : Int, private var column : Int){
    private val resetPoint = Pair(row,column)
    override fun toString() = userName
    fun getRow() = row
    fun getColumn() = column
    private fun setPosition(direction : Boolean, position : Int){
        if(direction){
            if(position < 0){
                Log.e("Logic Error!!", "$userName has been had minus position")
                return
            }

            column = position
        }else{
            if(position >= USER_MAX_LIMIT){
                Log.e("Logic Error!!", "$userName has been had out of limit position")
                return
            }
            row = position
        }
    }
    fun moveDown(){
        setPosition(false, row + 1)
    }
    fun moveRight(){
        setPosition(true, column + 1)
    }

    fun moveLeft(){
        setPosition(true, column - 1)
    }

    fun resetPosition(){
        setPosition(false, resetPoint.first)
        setPosition(true, resetPoint.second)
    }

    fun setRow(row : Int){
        setPosition(false, row)
    }
    fun setColumn(column : Int){
        setPosition(true, column)
    }
}

const val USER_MAX_LIMIT = 20
const val USER_MIN_LIMIT = 2