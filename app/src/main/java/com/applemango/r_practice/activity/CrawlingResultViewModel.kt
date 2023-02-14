package com.applemango.r_practice.activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CrawlingResultViewModel(application: Application) : AndroidViewModel(application) {

    private var posterLink : String = ""
    private var _posterUrl  = MutableLiveData<String>()
    val posterUrl : LiveData<String> get() = _posterUrl

    private var _movieName  = MutableLiveData<String>()
    val movieName : LiveData<String> get() = _movieName

    fun setPosterLink(link : String){
        posterLink = link
    }

    fun setMovieName(name : String){
        _movieName.value = name
    }

}