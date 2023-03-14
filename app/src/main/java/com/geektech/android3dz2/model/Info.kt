package com.geektech.android3dz2.model

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("count")
    val count: Int,

    @SerializedName("pages")
    val pages: Int,

    @SerializedName("next")
    val next: String,

    @SerializedName("pref")
    val pref: String
    )