package com.geektech.android3dz2.data.repoitories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.android3dz2.data.db.daos.LocationDao
import com.geektech.android3dz2.data.network.apiservices.LocationApiServices
import com.geektech.android3dz2.model.LocationModel
import com.geektech.android3dz2.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationApiServices: LocationApiServices,
    private val locationDao: LocationDao,
) {

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>> {
        val data: MutableLiveData<RickAndMortyResponse<LocationModel>> = MutableLiveData()
        locationApiServices.fetchLocation()
            .enqueue(object : retrofit2.Callback<RickAndMortyResponse<LocationModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    response: Response<RickAndMortyResponse<LocationModel>>,
                ) {
                    if (response.body() != null) {
                        response.body().let {
                            it?.let { it1 -> locationDao.insertAll(it1.result) }
                        }
                    }
                    data.value = response.body()
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
        locationApiServices.fetchLocationDetail(id)
            .enqueue(object : retrofit2.Callback<LocationModel> {
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

    fun getAll(): LiveData<List<LocationModel>> {
        return locationDao.getAll()
    }
}