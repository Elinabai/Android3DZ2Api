package com.geektech.android3dz2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "locationmodel")
data class LocationModel(

    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("dimension")
    val dimension: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("created")
    val created: String,
)