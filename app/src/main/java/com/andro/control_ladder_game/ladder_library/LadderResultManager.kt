package com.andro.control_ladder_game.ladder_library


class LadderResultManager(
    private val list : List<Int>,
    private val number : Int,
    private val absoluteBoomer : Int = -1)
{
    private val routeList : List<Pair<Boolean, Int>>

    init{
        routeList = makeRouteList()
    }

    fun makeRouteList() = listOf(Pair(false,0))

    fun getRouteList() = routeList
}