package com.applemango.r_practice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object MoviePosterBuilder {
    var baseURL : String = "https://openapi.naver.com/v1/"
    var p_api : MoviePosterAPI
    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        p_api = retrofit.create(MoviePosterAPI::class.java)
    }
}