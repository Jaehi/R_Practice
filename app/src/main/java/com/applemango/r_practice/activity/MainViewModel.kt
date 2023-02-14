package com.applemango.r_practice.activity

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.applemango.r_practice.ConstData
import com.applemango.r_practice.data.boxOffice.MovieResponse
import com.applemango.r_practice.ServerConnector
import com.applemango.r_practice.data.boxOffice.m_MovieDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val targetDateValue = LocalDate.now().minusDays(1)
    private val apiDateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val moviewResult = HashMap<String,String>()
    val movieList = MutableLiveData<MovieResponse>()
    private var _movieData = MutableLiveData<List<m_MovieDTO>>()
    val movieData : LiveData<List<m_MovieDTO>> get() = _movieData
    private var tempUrl = ""
    val text = MutableLiveData<String>("11")



    init {
        getMovieList()
        getMovieResult()
    }


    private fun getMovieList(){
        val targetDate = apiDateTimeFormatter.format(targetDateValue)
        ServerConnector.getMovieList(ConstData.API_KEY,targetDate){
            movieList.value = it
            _movieData.value = it.boxofficeResult?.dailyBoxOfficeList
            Log.d("????????????????????/**/","${movieData}")
        }
    }

    private fun getMovieResult(){
        CoroutineScope(Dispatchers.IO).launch {
            val url = "https://movie.naver.com/movie/sdb/rank/rmovie.naver"
            val doc = Jsoup.connect(url).get()
            val ele = doc.select("div[class=tit3]").select("a")

            ele.forEach{
                val title = it.attr("title")
                val code = it.attr("href").split("=")[1]
                val posterUrl = "https://movie.naver.com/movie/bi/mi/photoViewPopup.naver?movieCode=$code"
                getPoster(title,posterUrl)
                Log.d("asassaassaaasasa","${ moviewResult.keys.filter { it.contains(title) }} , ${
                    moviewResult[title]}")
            }
        }
    }
    fun getPoster(title: String , posterLink : String){

        CoroutineScope(Dispatchers.IO).launch {
            val url = posterLink
            val doc = Jsoup.connect(url).get()
            val ele = doc.select("div[id=page_content]").select("a").select("img")

            ele.forEach {
                val poster = it.attr("src")
                moviewResult[title] = poster
                Log.d("sdfjklsdfjkljklsdfjklsdf","${poster}")

            }
        }

    }
}