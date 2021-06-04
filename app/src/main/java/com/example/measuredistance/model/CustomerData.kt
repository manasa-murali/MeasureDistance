package com.example.measuredistance.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Manasa on 02,June,2021
 */

data class CustomerData(

        @SerializedName("user_id")
        val userID: Int,

        @SerializedName("name")
        val userName: String,

        @SerializedName("latitude")
        val latitude: Double,

        @SerializedName("longitude")
        val longitude: Double,
)

