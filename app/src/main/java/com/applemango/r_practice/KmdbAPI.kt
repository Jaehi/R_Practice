package com.applemango.r_practice

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface KmdbAPI {
    @GET("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2")
    fun getResult(
            @Header("ServiceKey") serviceKey : String,
            @Query("query") query : String
    )
}