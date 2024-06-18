package com.andro.control_ladder_game.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.andro.control_ladder_game.ladder_library.HorseData
import com.andro.control_ladder_game.ladder_library.USER_MAX_LIMIT
import com.andro.control_ladder_game.ladder_library.USER_MIN_LIMIT

private const val TAG = "UserViewModel"
class UserViewModel : ViewModel() {
    private var _userList = NonNullMutableLiveData(arrayListOf<HorseData>())
    val userList: LiveData<ArrayList<HorseData>>
        get() = _userList
    val userNumber : Int
        get() = _userList.value.size

    init{
        for(i in _userList.value.size until USER_MIN_LIMIT){
            _userList.value.add(HorseData(0,(i+1).toString()))
        }
    }
    fun createTheNewWorld(){
        if(userNumber >= USER_MAX_LIMIT)
            return

        val currentList = _userList.value
        currentList.add(HorseData(currentList.size + 1, (currentList.size + 1).toString()))
        _userList.value = currentList
    }

    fun deleteTheNewWorld(){
        if(userNumber <= USER_MIN_LIMIT)
            return

        val currentList = _userList.value ?: return
        if (currentList.isEmpty()) {
            return
        }
        currentList.removeLast()
        _userList.value = currentList
    }
}