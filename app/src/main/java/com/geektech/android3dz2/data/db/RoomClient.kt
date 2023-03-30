package com.geektech.android3dz2.data.db

import android.content.Context
import androidx.room.Room
import com.geektech.android3dz2.data.db.daos.CharacterDao
import com.geektech.android3dz2.data.db.daos.EpisodeDao
import com.geektech.android3dz2.data.db.daos.LocationDao

class RoomClient {

    fun provideRoom(context: Context) = Room
        .databaseBuilder(context, AppDataBase::class.java, "rick")
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()

    fun providerCharacterDao(appDataBase: AppDataBase): CharacterDao = appDataBase
        .characterDao()

    fun providerLocationDao(appDataBase: AppDataBase): LocationDao = appDataBase
        .locationDao()

    fun providerEpisodeDao(appDataBase: AppDataBase): EpisodeDao = appDataBase
        .episodeDao()
}