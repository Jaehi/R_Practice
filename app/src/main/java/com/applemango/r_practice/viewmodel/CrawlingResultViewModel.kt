package com.applemango.r_practice.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.applemango.r_practice.obj.ConstData
import com.applemango.r_practice.obj.ServerConnector
import com.applemango.r_practice.data.naver.m_NaverDTO

class CrawlingResultViewModel(application: Application) : AndroidViewModel(application) {

    private var _movieName  = MutableLiveData<String>()
    val movieName : LiveData<String> get() = _movieName

    private var _resultList = MutableLiveData<m_NaverDTO>()
    val resultList : LiveData<m_NaverDTO> get() = _resultList

    private var _movieStory = MutableLiveData<String>()
    val movieStory : LiveData<String> get() = _movieStory

    fun getMovieData(){
        movieName.value?.let { movieName ->
            ServerConnector.getMovieData(ConstData.NAVER_CLIENT_ID, ConstData.NAVER_CLIENT_SECRET, movieName){ result ->

                    result.posterresult.forEach {
                        val tempTitle = it.title?.replace("<b>","")?.replace("</b>","")
                        if (tempTitle.equals(movieName)){
                            _resultList.value = it
                            return@getMovieData
                        }
                    }
                }
             }
        }

    fun setMovieName(name : String) {
        _movieName.value = name
        Log.d("sdfjkfjklsdjklfsdjkldfsjkl", "${movieName.value}")
    }

    fun setMovieStory(story : String){
        _movieStory.value = story.replace(".", "\n")
    }

}