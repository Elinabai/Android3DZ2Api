package com.geektech.android3dz2.model

import com.google.gson.annotations.SerializedName

data class EpisodeModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("air_date")
    val air_date: String,

    @SerializedName("created")
    val created: String,

    @SerializedName("episode")
    val episode: String,
)
