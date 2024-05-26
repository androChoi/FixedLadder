package com.andro.control_ladder_game.ladder_library

import android.media.Image
import android.util.Log

private const val tag = "Logic Error!!"
open class DataChecker{
    /**Game 전역 변수에 설정된 최대 인원을 통해 Data가 정상적인지 확인한다
     * @param value number of People
     * @return this function returns Boolean : value >= USER_MAX_LIMIT */
    protected fun checkUserMaxLimit(value : Int) = value >= USER_MAX_LIMIT
    /**Game 전역 변수에 설정된 최소 인원을 통해 Data가 정상적인지 확인한다
     * @param value number of People
     * @return this function returns Boolean : value < USER_MIN_LIMIT */
    protected fun checkUserMinLimit(value : Int) = value < USER_MIN_LIMIT
    /**Game 중 말이 0 미만으로 가는 것을 체크한다.
     * @param value current point Of Horse
     * @return this function returns Boolean : value < 0 */
    protected fun checkZeroPoint(value : Int) = value < 0
    /**Game 중 말이 0 미만으로 가는 것을 체크한다.
     * @param value current point Of Horse
     * @return this function returns Boolean : value < 0 */
    protected fun checkNormalValue(value: Int) = value != -1
}

/**userData : userPhoto, userName/
 * State : row,column**/
data class HorseData(
    val userPhoto : Image? = null,
    val userName : String = "null",
    private var row : Int = -1,
    private var column : Int = -1
) : DataChecker()
{
    private val resetPoint = Pair(row,column)
    override fun toString() = userName
    fun getRow() = if(checkNormalValue(row))row
    else {
        Log.e(tag, "$userName returns -1 row!!")
        USER_ERROR_VALUE
    }
    fun getColumn() = if(checkNormalValue(column))column
    else {
        Log.e(tag, "$userName returns -1 column!!")
        USER_ERROR_VALUE
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

    private fun setPosition(direction : Boolean, position : Int){
        if(direction){
            if(checkZeroPoint(position)){
                Log.e(tag, "$userName has been had minus position")
                return
            }

            column = position
        }else{
            if(checkUserMaxLimit(position)){
                Log.e(tag, "$userName has been had out of limit position")
                return
            }
            row = position
        }
    }
}

const val USER_MAX_LIMIT = 10
const val USER_MIN_LIMIT = 2
const val USER_ERROR_VALUE = -1