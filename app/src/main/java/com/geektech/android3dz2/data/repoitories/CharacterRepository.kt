package com.geektech.android3dz2.data.repoitories

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.geektech.android3dz2.App
import com.geektech.android3dz2.data.repoitories.pagingsources.CharacterPagingSource
import com.geektech.android3dz2.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response

class CharacterRepository {

    fun fetchCharacter(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CharacterPagingSource(App.characterApiServices!!)
            }).flow
    }

    fun fetchCharacterDetail(id: Int): MutableLiveData<CharacterModel> {
        val data: MutableLiveData<CharacterModel> = MutableLiveData()
        App.characterApiServices?.fetchCharactersDetail(id)
            ?.enqueue(object : retrofit2.Callback<CharacterModel> {
                override fun onResponse(
                    call: Call<CharacterModel>,
                    response: Response<CharacterModel>,
                ) {
                    response.body()?.let {
                        data.value = it
                    }
                }

                override fun onFailure(
                    call: Call<CharacterModel>,
                    t: Throwable,
                ) {
                    data.value = null
                }
            })
        return data
    }
}