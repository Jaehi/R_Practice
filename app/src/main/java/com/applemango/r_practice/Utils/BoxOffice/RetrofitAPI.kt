package com.applemango.r_practice.Utils.BoxOffice


import com.applemango.r_practice.Data.BoxOffice.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {
    @GET("kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    fun getMovieList(
        @Query("key") key : String?,
        @Query("targetDt") targetDt : String?
    ):Call<MovieResponse>
}