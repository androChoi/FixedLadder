package com.andro.control_ladder_game.ladder_library

import android.util.Log


private const val TAG = "LadderRouteNavigator"
/**
 * LadderMap을 받은 Navigator는 결국 길을 찾는 것을 목표로 해야 한다.
 * 말들이 언젠가 길을 잃지 않게, 처음부터 올바른 길로 인도하는 것이다.
 * */
class LadderRouteNavigator(private val ladderMap : List<List<Int>>) {
    private val horseGoalList = makeHorseGoalList()
    private val naviData = makeNavigationDataList()
    private val size = ladderMap.size
    fun getGoalList() = horseGoalList

    private fun makeHorseGoalList() : List<List<Int>>{
        val returnList = arrayListOf(listOf<Int>())

        for(i in 0 until size){
            returnList.add(navigateRoute(i,naviData))
        }

        return listOf(listOf(0))
    }

    private fun makeNavigationDataList() : List<NavigationData>{
        val rl = arrayListOf<NavigationData>()

        for(i in ladderMap.indices){
            ladderMap[i].forEach {
                rl.add(NavigationData(i,it))
            }
        }

        val q = rl.sortedBy { it.col }

        Log.i(TAG,"naviData : $q")
        return q
    }

    private fun navigateRoute(num : Int, route : List<NavigationData>) : List<Int>{
        val rl = arrayListOf<Int>()
        var state = num

        for(i in route.indices){
            if(state == 0 && route[i].row == 1){
                state ++
                rl.add(route[i].col)
            }
            if(state == size-1 && route[i].row == size-1){
                //가독성 ㅋ
                state --
                rl.add(route[i].col * -1)
            }
            if(state == route[i].row){
                state ++
                rl.add(route[i].col)
            }
            if(state -1 == route[i].row){
                state --
                //가독성 ㅋ
                rl.add(route[i].col * -1)
            }
        }

        return rl
    }
    private data class NavigationData(val row : Int, val col : Int)
}