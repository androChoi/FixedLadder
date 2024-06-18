package com.andro.control_ladder_game.ladder_library

import android.media.Image
import android.util.Log
import android.widget.ImageView

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

data class HorseData(
    var image : Int,
    var name : String,
)

const val USER_MAX_LIMIT = 10
const val USER_MIN_LIMIT = 2
const val USER_ERROR_VALUE = -1