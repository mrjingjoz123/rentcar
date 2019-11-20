package com.s59161111.rentcar.about

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class AboutViewModel (
     application: Application) : AndroidViewModel (application){

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