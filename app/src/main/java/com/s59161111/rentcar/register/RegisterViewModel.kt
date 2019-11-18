package com.s59161111.rentcar.register

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class RegisterViewModel (
     application: Application) : AndroidViewModel (application){

     private val _eventClickBack = MutableLiveData<Boolean>()
     val eventClickBack : LiveData<Boolean>
          get() = _eventClickBack

     private val _eventGetInput = MutableLiveData<Boolean>()
     val eventGetInput : LiveData<Boolean>
          get() = _eventGetInput

     private val _eventClickSave = MutableLiveData<Boolean>()
     val eventClickSave : LiveData<Boolean>
          get() = _eventClickSave


     init {
          _eventClickBack.value = false
          _eventGetInput.value = false
          _eventClickSave.value = false

     }
     fun BackPress(){
          _eventClickBack.value = true
     }

     fun SavePress(){
          _eventGetInput.value = true
     }

     fun getInput(user:String,pass:String,email:String,phone:String){
          checkNull(user,pass,email,phone)
     }

     private fun checkNull(user: String, pass: String, email: String, phone: String) {
          if (user != "" && pass != "" && email != "" && phone != ""){
               _eventClickSave.value = true
          }else{
               Log.i("RegisterViewModel","NULL")
          }
     }


}