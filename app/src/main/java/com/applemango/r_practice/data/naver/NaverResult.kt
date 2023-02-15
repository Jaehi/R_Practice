package com.applemango.r_practice.data.naver

import com.google.gson.annotations.SerializedName

class NaverResult {
    @SerializedName("items")
    var posterresult : MutableList<m_NaverDTO> = arrayListOf()
}