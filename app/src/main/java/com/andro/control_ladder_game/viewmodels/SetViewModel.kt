package com.andro.control_ladder_game.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.andro.control_ladder_game.LadderApp
import com.andro.control_ladder_game.recycler_adapters.ProbabilityItem

private const val TAG = "SetViewModel"
class SetViewModel : ViewModel() {
    val probabilityList = NonNullMutableLiveData(arrayListOf<ProbabilityItem>())

    fun loadProbabilityList(number : Int){
        var list = LadderApp.instance.prefs.probabilityList
        Log.i(TAG, "loadProbabilityList : $list")
//        if(list.contains(-1))
//            list = makeNewProbabilityList(number)

        LadderApp.instance.prefs.probabilityList = list
    }

//    private fun makeNewProbabilityList(number : Int) : List<Int>{
//
//    }
}