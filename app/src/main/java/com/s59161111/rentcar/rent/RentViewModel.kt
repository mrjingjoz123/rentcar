package com.s59161111.rentcar.rent

import android.graphics.Picture
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RentViewModel : ViewModel(){

    private val _eventClickBack = MutableLiveData<Boolean>()
    val eventClickBack : LiveData<Boolean>
        get() = _eventClickBack

    private val _eventClickPicture1 = MutableLiveData<Boolean>()
    val eventClickPicture1 : LiveData<Boolean>
        get() = _eventClickPicture1

    private val _eventClickPicture2 = MutableLiveData<Boolean>()
    val eventClickPicture2 : LiveData<Boolean>
        get() = _eventClickPicture2

    init {
        _eventClickBack.value = false
        _eventClickPicture1.value = false
        _eventClickPicture2.value = false

    }

    fun BackPress(){
        _eventClickBack.value = true
    }

    fun Picture1Press(){
        _eventClickPicture1.value = true
    }
    fun Picture2Press(){
        _eventClickPicture2.value = true
    }
}