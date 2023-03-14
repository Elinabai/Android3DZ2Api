package com.geektech.android3dz2

import android.app.Application
import com.geektech.android3dz2.data.network.RetrofitClient
import com.geektech.android3dz2.data.network.apiservices.CharacterApiServices
import com.geektech.android3dz2.data.network.apiservices.EpisodeApiServices
import com.geektech.android3dz2.data.network.apiservices.LocationApiServices

class App: Application() {

    companion object{
        var characterApiServices: CharacterApiServices? = null
        var locationApiServices: LocationApiServices? = null
        var episodeApiServices: EpisodeApiServices? = null
    }

    override fun onCreate() {
        super.onCreate()

        characterApiServices = RetrofitClient().provideCharacterApiServices()
        locationApiServices = RetrofitClient().provideLocationApiServices()
        episodeApiServices = RetrofitClient().provideEpisodeApiServices()
    }
}