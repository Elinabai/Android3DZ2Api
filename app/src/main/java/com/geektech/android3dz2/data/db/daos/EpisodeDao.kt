package com.geektech.android3dz2.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geektech.android3dz2.model.EpisodeModel

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM episodeModel")
    fun getAll(): LiveData<List<EpisodeModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(episodeModel: List<EpisodeModel>)
}