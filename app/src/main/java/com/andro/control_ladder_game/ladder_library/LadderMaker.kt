package com.andro.control_ladder_game.ladder_library

import android.util.Log
import kotlin.random.Random
import kotlin.random.nextInt

private const val TAG = "LadderMaker"
open class LadderMaker(private val userNumber : Int) {
    //Top ~ Bottom 사이에만 사다리 스텝이 생성
    //3분할 하지 않으면 사다리 쏠림 현상 발생하기 때문이다.
    //값은 0~100이다
    private val topTop = 10
    private val topBottom = 25
    private val topMaxCount = 0
    private val topMinCount = 2

    private val midTop = 35
    private val midBottom = 65
    private val midMaxCount = 1
    private val midMinCount = 4

    private val btmTop = 75
    private val btmBottom = 90
    private val btmMaxCount = 0
    private val btmMinCount = 2
    fun getLadderMap() : List<List<Int>>{
        return makeLadderMap()
    }

    private fun makeLadderMap() : List<List<Int>>{
        val ladderMap = arrayListOf(arrayListOf<Int>())
        ladderMap.add(makeRandomLadderStepBar())
        Log.i(TAG, "makeLadderMap step list 1 : ${ladderMap[0]}")

        for(i in 1 until userNumber){
            ladderMap.add(makeRandomLadderStepBar())
            Log.i(TAG, "makeLadderMap step list $i : ${ladderMap[i]}")
        }

        return ladderMap
    }

    private fun makeRandomLadderStepBar() : ArrayList<Int> {
        val stepList = arrayListOf<Int>()
        val rangeList = listOf(topTop .. topBottom, midTop .. midBottom, btmTop .. btmBottom)
        val sizeList = listOf(
            Random.nextInt(topMinCount,topMaxCount),
            Random.nextInt(midMinCount,midMaxCount),
            Random.nextInt(btmMinCount,btmMaxCount)
        )

        rangeList.forEachIndexed { index, intRange ->
            makeLadderStepBar(sizeList[index], intRange).forEach{step ->
                stepList.add(step)
            }
            Log.i(TAG, "makeRandomLadderStepBar stepList[$index] : ${stepList[index]}")
        }

        return stepList
    }

    /**Margin은 넣을 수도 있는데,,, UI 넣을 때 넣어야 함
     * 다만 사다리 개수와 백분율 사이의 계산식이 필요하다*/
    private fun makeLadderStepBar(stepSize : Int, range : IntRange) : ArrayList<Int>{
        Log.i(TAG, "makeLadderStepBar stepSize : $stepSize")
        val stepList = arrayListOf<Int>()
        if(stepSize == 0)
            return stepList
        stepList.add(Random.nextInt(range))

        for(i in 1 until stepSize){
            var emergencyCnt = 0
            while(true){
                val stepBar = Random.nextInt(range)
                var flag = true

                stepList.forEach {
                    if(stepBar + 5 >= it && stepBar - 5 <= it)
                        flag = false
                }

                if(flag || emergencyCnt ++ > 22){
                    stepList.add(stepBar)
                }
            }
        }

        return stepList
    }
}