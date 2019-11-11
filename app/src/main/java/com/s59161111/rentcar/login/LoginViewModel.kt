package com.s59161111.rentcar.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    private val _eventClickLogin = MutableLiveData<Boolean>()
    val eventClickLogin : LiveData<Boolean>
        get() = _eventClickLogin

    private val _eventGetInput = MutableLiveData<Boolean>()
    val eventGetInput : LiveData<Boolean>
        get() = _eventGetInput

    private val _eventRegis = MutableLiveData<Boolean>()
    val eventRegis : LiveData<Boolean>
        get() = _eventRegis

    init {
        _eventClickLogin.value = false
        _eventGetInput.value = false
        _eventRegis.value = false
    }

    fun LoginPress(){
        _eventGetInput.value = true
    }
    fun RegisPress(){
        _eventRegis.value = true
    }

    fun getInput(user:String , pass:String){
        checkNull(user,pass)
    }

    fun checkNull(user:String , pass:String) {
        if (user != "" && pass != ""){
            _eventClickLogin.value = true
        }else{
            Log.i("LoginViewModel","NULL")
        }
    }

}
