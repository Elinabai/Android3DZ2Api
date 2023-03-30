package com.geektech.android3dz2

import android.app.Application

import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class
App : Application()
//
//    companion object {
//        var retrofitClient = RetrofitClient()
//        var characterApiServices: CharacterApiServices? = null
//        var locationApiServices: LocationApiServices? = null
//        var episodeApiServices: EpisodeApiServices? = null
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        characterApiServices = retrofitClient.provideCharacterApiServices()
//        locationApiServices = retrofitClient.provideLocationApiServices()
//        episodeApiServices = retrofitClient.provideEpisodeApiServices()
//    }
//}