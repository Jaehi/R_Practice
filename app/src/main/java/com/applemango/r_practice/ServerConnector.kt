package com.applemango.r_practice

import android.util.Log
import com.applemango.r_practice.data.boxOffice.MovieResponse
import com.applemango.r_practice.data.naver.NaverResult
import com.applemango.r_practice.utils.BoxOffice.RetrofitBuilder
import com.applemango.r_practice.utils.Naver.NaverBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ServerConnector {

    private val apiServer  = RetrofitBuilder.api
    private val naverServer = NaverBuilder.p_api

    fun getMovieList(key : String, targetDate : String, callback :(MovieResponse) -> Unit){
        apiServer.getMovieList(key, targetDate).enqueue {
            Log.d("CCCCCCCCC","$it")
            callback(it)
        }
    }

    fun getMovieData(clientId : String, clientSecret : String , movieName : String , callback : (NaverResult) -> Unit){
        naverServer.getPoster(clientId,clientSecret,movieName).enqueue {
            callback(it)
        }
    }

    private inline fun <T> Call<T>.enqueue(crossinline function: (body: T) -> Unit) {
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.body() == null)
                else
                    function(response.body()!!)
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                Log.d("Fail","$t")
            }
        })
    }

}