package com.andro.control_ladder_game.ladder_library

import android.util.Log
import kotlin.random.Random


private const val TAG = "LadderResultManager"
/**
 * ### LadderResultManager
 *   - Instance is made by LadderMaster firstly.
 *   - It mainly results on the data : probabilities
 *   - Obviously this sets on result of ladder game before start.
 *   - In other words, it must have a function that decides result about user information.
 *   - So this class can make a result of this game and return data of result.
 *   - Place that return the result is argument of LadderMaker in LadderMaster class.
 *   - Finally, Int of parameters is only fixed result.
 *   - For example, if Int parameter is -1, just result fallows the list data.
 *   - However, if Int parameter is else value(range in user data list size),
 *   then it fixes the number of result and returns.
 *   - return data format is List(RouteData)*/
class LadderResultManager(
    private val userNumber : Int,
    private val probabilityList : List<Int>,
    private val absoluteBoomer : Int = -1
){
    fun getBoomerNumber() =
        if(absoluteBoomer in 0 until userNumber){
            Log.i(TAG, "selectRouteModeList absolute Boomer: $absoluteBoomer")
            absoluteBoomer
        }else{
            makeNewAbsoluteBoomer()
        }

    /**
     * User로부터 받은 확률 리스트에서 당첨 번호를 미리 뽑는다.
     * boomerList에 당첨 수치를 난수를 통해 생성
     * 난수 list는 selectKingOfBoomers를 통해서 가장 큰 당첨 수치를 가지고 있는 인덱스를 반환
     * 이 인덱스가 당첨 번호*/
    private fun makeNewAbsoluteBoomer() : Int{
        Log.i(TAG, "makeNewAbsoluteBoomer")
        val boomerList = Array(userNumber){0}

        for(i in 0 until userNumber){
            boomerList[i] = makeBoomerCountNumber(probabilityList[i])
            if(boomerList[i] == -1) {
                Log.i(TAG, "makeNewAbsoluteBoomer returns -1")
                return Random.nextInt(0,userNumber)
            }
        }
        Log.i(TAG, "makeNewAbsoluteBoomer List : $boomerList")
        return selectKingOfBoomers(boomerList.toList())
    }

    /**
     * 확률이 높을 수록 높은 당첨 수치를 만들어 낼 확률이 큰 함수
     * 확률의 크기로 이상한 수치가 나오지 않게 유의미한 범위(0 until userNumber) 지정
     * @param probability : 이 값이 클수록 큰 값을 반환할 확률이 크다*/
    private fun makeBoomerCountNumber(probability : Int) : Int{
        var count = 0
        for(i in 0 until probability){
            //1/userNumber 확률에 따라 당첨 번호를 결정. 0이 가장 많은 번호가 나올수록 당첨
            if(0 == Random.nextInt(0, userNumber))
                count ++
        }

        return count
    }

    /**
     * 리스트 안에 당첨 수치가 같을 확률도 충분히 있기 때문에 그들 중 하나를 뽑아야 함
     * 무조건 이것도 랜덤...
     * @param list : List<Int>*/
    private fun selectKingOfBoomers(list : List<Int>) : Int{
        Log.i(TAG,"selectKingOfBoomers")
        val valueOfKing = list.max()
        var numOfGoodBoomers = 0
        val idxOfGoodBoomers = arrayListOf<Int>()

        for(i in list.indices){
            if(list[i] == valueOfKing) {
                numOfGoodBoomers++
                idxOfGoodBoomers.add(i)
            }
        }
        //최대값을 가지고 있는 당첨 수치 최고자들이 1개를 초과한다면 그 인덱스 중에 하나만 return
        if(numOfGoodBoomers > 1){
            val king = Random.nextInt(0,numOfGoodBoomers)
            Log.i(TAG, "selectKingOfBoomers : $king")
            return idxOfGoodBoomers[king]
        }
        Log.i(TAG, "selectKingOfBoomers : ${idxOfGoodBoomers[0]}")

        //1개면 그냥 0번 주고 말지 뭥
        return idxOfGoodBoomers[0]
    }
}