package com.applemango.r_practice

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
           // @Query("image") image : String?,
           // @Query("title") title : String?
    ):Call<NaverResult>
}