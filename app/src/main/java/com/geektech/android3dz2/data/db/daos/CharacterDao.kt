package com.geektech.android3dz2.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geektech.android3dz2.model.CharacterModel

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characterModel")
    fun getAll(): LiveData<List<CharacterModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(characterModel: List<CharacterModel>)
}