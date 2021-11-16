package com.applemango.r_practice.Data.BoxOffice

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("boxOfficeResult")
    var boxofficeResult : BoxOfficeResult?
)
