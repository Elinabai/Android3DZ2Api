package com.geektech.android3dz2.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.android3dz2.App
import com.geektech.android3dz2.model.LocationModel
import com.geektech.android3dz2.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Response

class LocationViewModel : ViewModel() {

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>> {
        val data: MutableLiveData<RickAndMortyResponse<LocationModel>> = MutableLiveData()
        App.locationApiServices?.fetchLocation()
            ?.enqueue(object : retrofit2.Callback<RickAndMortyResponse<LocationModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    response: Response<RickAndMortyResponse<LocationModel>>,
                ) {
                    response.body()?.let {
                        data.value = it
                    }
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    t: Throwable,
                ) {
                    data.value = null
                }

            })
        return data
    }
}