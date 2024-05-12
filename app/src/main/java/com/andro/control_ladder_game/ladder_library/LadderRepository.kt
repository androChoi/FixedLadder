package com.andro.control_ladder_game.ladder_library

object LadderRepository {
    /**pr : 1*/var absoluteBoomer = -1
        get() =
            if(field <= -1) -1
            else field
        set(value) {
            field = if(value <= -1) -1
            else if(value >= USER_MAX_LIMIT) USER_MAX_LIMIT-1
            else value
        }
    /**pr : 2*/private var absoluteName = ""
    /**pr : 3*/private lateinit var horseDataList : List<HorseData>
    /**pr : 4*/private lateinit var probabilityList : List<Int>

    fun setHorseDataList(list : List<HorseData>) : Boolean{
        if(list.size < USER_MIN_LIMIT) return false

        horseDataList = list
        return true
    }

    fun getHorseDataList() =
        if(horseDataList.isNullOrEmpty()) listOf(HorseData())
        else horseDataList

    fun setProbabilityDataList(list : List<Int>) : Boolean{
        if(list.size < USER_MIN_LIMIT) return false

        probabilityList = list
        return true
    }

    fun getProbabilityDataList() =
        if(probabilityList.isNullOrEmpty()) listOf(-1)
        else probabilityList
}