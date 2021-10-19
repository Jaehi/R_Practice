package com.applemango.r_practice

import retrofit2.http.GET

interface MoviePosterAPI {
    @GET("https://openapi.naver.com/v1/search/movie.json")
    fun getPoster()
}