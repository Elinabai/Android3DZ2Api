package com.geektech.android3dz2.model

import com.google.gson.annotations.SerializedName

data class LocationModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("dimension")
    val dimension: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("created")
    val created: String
)