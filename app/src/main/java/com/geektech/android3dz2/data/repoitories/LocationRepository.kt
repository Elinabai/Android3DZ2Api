package com.geektech.android3dz2.data.repoitories

import androidx.lifecycle.MutableLiveData
import com.geektech.android3dz2.App
import com.geektech.android3dz2.model.LocationModel
import com.geektech.android3dz2.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Response

class LocationRepository {

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

    fun fetchLocationDetail(id: Int): MutableLiveData<LocationModel> {
        val data: MutableLiveData<LocationModel> = MutableLiveData()
        App.locationApiServices?.fetchLocationDetail(id)
            ?.enqueue(object : retrofit2.Callback<LocationModel> {

                override fun onResponse(
                    call: Call<LocationModel>,
                    response: Response<LocationModel>,
                ) {
                    response.body()?.let {
                        data.value = it
                    }
                }

                override fun onFailure(
                    call: Call<LocationModel>,
                    t: Throwable,
                ) {
                    data.value = null
                }
            })
        return data
    }
}