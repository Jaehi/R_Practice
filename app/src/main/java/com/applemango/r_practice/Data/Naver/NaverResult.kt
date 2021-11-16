package com.applemango.r_practice.Data.Naver

import com.google.gson.annotations.SerializedName

class NaverResult {
    @SerializedName("items")
    var posterresult : List<m_NaverDTO> = arrayListOf()
}