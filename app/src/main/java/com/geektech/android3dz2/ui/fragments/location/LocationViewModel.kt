package com.geektech.android3dz2.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.android3dz2.data.repoitories.LocationRepository
import com.geektech.android3dz2.model.LocationModel
import com.geektech.android3dz2.model.RickAndMortyResponse

class LocationViewModel : ViewModel() {

    private val locationRepository = LocationRepository()

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>> {
        return locationRepository.fetchLocation()
    }

    fun fetchLocationDetail(id: Int): MutableLiveData<LocationModel> {
        return locationRepository.fetchLocationDetail(id)
    }
}