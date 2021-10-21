package com.applemango.r_practice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NaverBuilder {
    var baseURL : String = "https://openapi.naver.com/v1/"
    var p_api : NaverAPI
    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        p_api = retrofit.create(NaverAPI::class.java)
    }
}