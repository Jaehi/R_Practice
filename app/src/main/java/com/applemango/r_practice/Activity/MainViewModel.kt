package com.applemango.r_practice.Activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.applemango.r_practice.ConstData
import com.applemango.r_practice.Data.BoxOffice.MovieResponse
import com.applemango.r_practice.ServerConnector
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val targetDateValue = LocalDate.now()
    private val apiDateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val movieList = MutableLiveData<MovieResponse>()
    val text = MutableLiveData<String>("11")

    init {
        getMovieList()
    }


    private fun getMovieList(){
        val targetDate = apiDateTimeFormatter.format(targetDateValue)
        ServerConnector.getMovieList(ConstData.API_KEY,targetDate){
            movieList.value = it
        }
    }
}