package com.example.draggerbasic.model

import com.google.gson.annotations.SerializedName

/**
 * Created by PrernaSurbhi on 26/03/22.
 */
data class Country(
    @SerializedName("name")
    val countryName: String?,
    @SerializedName("capital")
    val capital: String?,
    @SerializedName("flagPNG")
    val flag: String?
    )