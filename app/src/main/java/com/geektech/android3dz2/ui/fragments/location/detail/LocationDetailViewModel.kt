package com.geektech.android3dz2.ui.fragments.location.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.android3dz2.data.repoitories.LocationRepository
import com.geektech.android3dz2.model.LocationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationDetailViewModel@Inject constructor(
    private val locationRepository: LocationRepository
): ViewModel() {

    fun fetchLocationDetail(id: Int): MutableLiveData<LocationModel> {
        return locationRepository.fetchLocationDetail(id)
    }
}
