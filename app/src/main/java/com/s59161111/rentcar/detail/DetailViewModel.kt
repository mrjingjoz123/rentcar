package com.s59161111.rentcar.detail

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.s59161111.rentcar.rent.x

class DetailViewModel (
    application: Application
) : AndroidViewModel(application){

    private val _eventClickBack = MutableLiveData<Boolean>()
    val eventClickBack : LiveData<Boolean>
        get() = _eventClickBack



    init {
        _eventClickBack.value = false

    }

    fun BackPress(){

        _eventClickBack.value = true
    }



}