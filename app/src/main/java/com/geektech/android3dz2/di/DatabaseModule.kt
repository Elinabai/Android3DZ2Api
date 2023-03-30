package com.geektech.android3dz2.di

import android.content.Context
import com.geektech.android3dz2.data.db.AppDataBase
import com.geektech.android3dz2.data.db.RoomClient
import com.geektech.android3dz2.data.db.daos.CharacterDao
import com.geektech.android3dz2.data.db.daos.EpisodeDao
import com.geektech.android3dz2.data.db.daos.LocationDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    val roomClient = RoomClient()

    @Singleton
    @Provides
    fun providerRoom(
        @ApplicationContext context: Context,
    ): AppDataBase = roomClient.provideRoom(context)

    @Singleton
    @Provides
    fun providerCharacterDao(
        appDataBase: AppDataBase,
    ): CharacterDao = roomClient.providerCharacterDao(appDataBase)

    @Singleton
    @Provides
    fun providerLocationDao(
        appDataBase: AppDataBase,
    ): LocationDao = roomClient.providerLocationDao(appDataBase)

    @Singleton
    @Provides
    fun providerEpisodeDao(
        appDataBase: AppDataBase,
    ): EpisodeDao = roomClient.providerEpisodeDao(appDataBase)
}