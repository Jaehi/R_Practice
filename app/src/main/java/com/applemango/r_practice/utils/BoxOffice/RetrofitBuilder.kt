package com.applemango.r_practice.utils.BoxOffice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    var baseURL : String = "http://www.kobis.or.kr/"
    var api : RetrofitAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(RetrofitAPI::class.java)
    }

}