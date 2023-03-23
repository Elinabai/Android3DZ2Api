package com.geektech.android3dz2.data.network.apiservices

import com.geektech.android3dz2.model.LocationModel
import com.geektech.android3dz2.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApiServices {

    @GET("api/location")
    suspend fun fetchLocation(@Query("page")page: Int):RickAndMortyResponse<LocationModel>

    @GET("api/episode/{id}")
    fun fetchLocationDetail(@Path("id") id: Int): Call<LocationModel>
}
