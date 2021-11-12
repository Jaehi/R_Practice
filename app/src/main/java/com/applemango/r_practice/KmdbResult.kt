package com.applemango.r_practice

import com.google.gson.annotations.SerializedName

data class KmdbResult (
    @SerializedName("Data")
    var kmdbResponse : KmdbResponse?
 )