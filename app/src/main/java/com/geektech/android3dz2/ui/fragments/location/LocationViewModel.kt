package com.geektech.android3dz2.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.geektech.android3dz2.data.repoitories.LocationRepository
import com.geektech.android3dz2.model.LocationModel

class LocationViewModel : ViewModel() {

    private val locationRepository = LocationRepository()

    fun fetchLocation() = locationRepository.fetchLocation().cachedIn(viewModelScope)

    fun fetchLocationDetail(id: Int): MutableLiveData<LocationModel> {
        return locationRepository.fetchLocationDetail(id)
    }
}