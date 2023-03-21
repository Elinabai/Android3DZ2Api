package com.geektech.android3dz2.data.repoitories

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.geektech.android3dz2.App
import com.geektech.android3dz2.data.repoitories.pagingsources.LocationPagingSource
import com.geektech.android3dz2.model.LocationModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response

class LocationRepository {

    fun fetchLocation(): Flow<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                LocationPagingSource(App.locationApiServices!!)
            }).flow
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