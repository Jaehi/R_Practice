package com.applemango.r_practice.Data.BoxOffice

import com.google.gson.annotations.SerializedName

data class BoxOfficeResult(
    @SerializedName("dailyBoxOfficeList")
    var dailyBoxOfficeList : List<m_MovieDTO> = arrayListOf()
)