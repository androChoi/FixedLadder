package com.andro.control_ladder_game.ladder_library

object LadderRepository {
    /**priority(1). 1이 선택되어있을 경우 무조건 얘로 사다리를 만든다. */var absoluteNumber = -1
        get() =
            if(field <= -1) -1
            else field
        set(value) {
            field = if(value <= -1) -1
            else if(value >= USER_MAX_LIMIT) USER_MAX_LIMIT-1
            else value
        }
    /**priority(2). 1이 선택되어 있지 않고 name 중 얘가 있으면 얘로 사다리를 만든다.*/private var absoluteName = ""
    /**priority(3). 1, 2가 선택되어 있지 않으면 얘로 확률을 내서 만든다 */private lateinit var probabilityList : List<Int>
    /**horse data*/
    private lateinit var horseDataList : List<HorseData>

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