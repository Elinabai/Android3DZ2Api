package com.geektech.android3dz2.data.network.apiservices

import com.geektech.android3dz2.model.LocationModel
import com.geektech.android3dz2.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface LocationApiServices {
    @GET("api/location")
    fun fetchLocation(): Call<RickAndMortyResponse<LocationModel>>
}