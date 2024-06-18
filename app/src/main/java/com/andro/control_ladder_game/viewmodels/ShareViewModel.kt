package com.andro.control_ladder_game.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel : ViewModel(){

}

class NonNullMutableLiveData<T : Any>(value : T) : MutableLiveData<T>(value){
    override fun getValue(): T {
        return super.getValue() ?: throw IllegalStateException("Value cannot be null")
    }

    override fun setValue(value: T) {
        super.setValue(value)
    }

    override fun postValue(value: T) {
        super.postValue(value)
    }
}