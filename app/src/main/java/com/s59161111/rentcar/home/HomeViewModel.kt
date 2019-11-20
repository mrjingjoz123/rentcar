package com.s59161111.rentcar.home


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    private val _eventClickGo = MutableLiveData<Boolean>()
    val eventClickGo : LiveData<Boolean>
        get() = _eventClickGo



    private val _eventAbout = MutableLiveData<Boolean>()
    val eventAbout : LiveData<Boolean>
        get() = _eventAbout

    init {
        _eventClickGo.value = false
        _eventAbout.value = false
    }

    fun GoPress(){
        Log.i("Click Go", "Success")
        _eventClickGo.value = true
    }
    fun AboutPress(){
        _eventAbout.value = true
    }

}
