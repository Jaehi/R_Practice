package com.applemango.r_practice

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("boxOfficeResult")
    var boxofficeResult : BoxOfficeResult?
)
