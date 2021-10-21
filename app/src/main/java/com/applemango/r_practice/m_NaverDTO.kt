package com.applemango.r_practice

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class m_NaverDTO (

        @SerializedName("title")
        var title : String?,
        @SerializedName("image")
        var image : String
        ):Serializable{

        }

