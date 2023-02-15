package com.applemango.r_practice.activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CrawlingResultViewModel(application: Application) : AndroidViewModel(application) {

    private var _movieName  = MutableLiveData<String>()
    val movieName : LiveData<String> get() = _movieName

    fun setMovieName(name : String){
        _movieName.value = name
    }

}