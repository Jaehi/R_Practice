package com.applemango.r_practice.utils.Naver

import com.applemango.r_practice.data.naver.NaverResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverAPI {
    @GET("https://openapi.naver.com/v1/search/movie.json")
    fun getPoster(
            @Header("X-Naver-Client-Id") clientID : String? ,
            @Header("X-Naver-Client-Secret") clientSecreat : String?,
            @Query("query") query : String?,

    ):Call<NaverResult>
}