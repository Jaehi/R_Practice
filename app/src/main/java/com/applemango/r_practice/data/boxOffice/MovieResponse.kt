package com.applemango.r_practice.data.boxOffice

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("boxOfficeResult")
    var boxofficeResult : BoxOfficeResult?
)
