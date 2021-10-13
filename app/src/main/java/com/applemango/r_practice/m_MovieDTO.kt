package com.applemango.r_practice

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class m_MovieDTO(
    @SerializedName("movieNm")
    var movieNm : String?,
    @SerializedName("rank")
    var rank : String?
) : Serializable{

}
