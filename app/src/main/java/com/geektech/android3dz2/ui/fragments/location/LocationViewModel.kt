package com.geektech.android3dz2.ui.fragments.location

import androidx.lifecycle.ViewModel
import com.geektech.android3dz2.data.repoitories.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationRepository: LocationRepository
) : ViewModel() {

    fun fetchLocation() = locationRepository.fetchLocation()

    fun getAll() = locationRepository.getAll()
}