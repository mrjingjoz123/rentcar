package com.s59161111.rentcar.detail

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.s59161111.rentcar.database.Book
import com.s59161111.rentcar.database.BookDatabaseDao
import com.s59161111.rentcar.rent.x
import kotlinx.coroutines.*

class DetailViewModel(val database: BookDatabaseDao, application: Application) : AndroidViewModel(application) {


    private val _eventClickBack = MutableLiveData<Boolean>()
    val eventClickBack : LiveData<Boolean>
        get() = _eventClickBack

    private val _eventClickSave = MutableLiveData<Boolean>()
    val eventClickSave : LiveData<Boolean>
        get() = _eventClickSave

    private val _eventCheckInput = MutableLiveData<Boolean>()
    val eventCheckInput : LiveData<Boolean>
        get() = _eventCheckInput

    private val _Init = MutableLiveData<Boolean>()
    val Init : LiveData<Boolean>
        get() = _Init

    private val _detail = MutableLiveData<String>()
    val detail : LiveData<String>
        get() = _detail

    private val _price = MutableLiveData<String>()
    val price : LiveData<String>
        get() = _price

    val _popUp = MutableLiveData<Boolean>()
    val popUp : LiveData<Boolean>
        get() = _popUp


    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var Bicycle : Int = 0

    init {
        _eventClickBack.value = false
        _eventClickSave.value = false
        _Init.value = true
        _eventCheckInput.value = false
        _popUp.value = false

    }

    fun getSafe(bicycle:Int) {
        Bicycle = bicycle
        if(bicycle == 1){
            _detail.value = "DETAIL : สีแดง น้ำหนักเบา"
            _price.value = "PRICE : 300"
        }else if(bicycle == 2){
            _detail.value = "DETAIL : สีเหลือง น้ำหนักเบา"
            _price.value = "PRICE : 200"
        }

    }

    fun BackPress(){
        _eventClickBack.value = true
    }

    fun  ClickPress(name:String){
        uiScope.launch {
        Log.i("DetailViewModel","${name}")
        if(name != "" || name != null){

                var bookingData = Book(
                    name = name,
                    bike = Bicycle.toString()
                )
                insert(bookingData)
                Log.i("DetailViewModel","${getToBookFromDatabase()}")
                _eventClickSave.value = true

        }else{
            _popUp.value = true
        }
    }
    }

    fun checkInput(){
        _eventCheckInput.value = true
    }




    private suspend fun insert(data: Book) {
        withContext(Dispatchers.IO) {
            database.insert(data)
        }
    }


    private suspend fun getToBookFromDatabase(): Book? {
        return withContext(Dispatchers.IO) {
            var started = database.getToStarted()
            started
        }


    }







}