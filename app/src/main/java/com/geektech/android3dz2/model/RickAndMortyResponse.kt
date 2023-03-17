package com.geektech.android3dz2.model

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse<T>(

    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val result: ArrayList<T>,
)
