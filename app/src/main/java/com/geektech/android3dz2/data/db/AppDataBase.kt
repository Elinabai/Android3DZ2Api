package com.geektech.android3dz2.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.geektech.android3dz2.data.db.daos.CharacterDao
import com.geektech.android3dz2.data.db.daos.EpisodeDao
import com.geektech.android3dz2.data.db.daos.LocationDao
import com.geektech.android3dz2.model.CharacterModel
import com.geektech.android3dz2.model.EpisodeModel
import com.geektech.android3dz2.model.LocationModel
import com.geektech.android3dz2.utils.ObjectConverter

@Database(entities = [CharacterModel::class, LocationModel::class, EpisodeModel::class], version = 2)
@TypeConverters(ObjectConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
    abstract fun episodeDao(): EpisodeDao
}