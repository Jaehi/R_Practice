package com.applemango.r_practice

import com.google.gson.annotations.SerializedName

class KmdbResponse {
    @SerializedName("Result")
    var Data : List<m_LastDTO> = arrayListOf()
}