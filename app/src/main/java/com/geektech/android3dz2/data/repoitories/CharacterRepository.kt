package com.geektech.android3dz2.data.repoitories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.android3dz2.data.db.daos.CharacterDao
import com.geektech.android3dz2.data.network.apiservices.CharacterApiServices
import com.geektech.android3dz2.model.CharacterModel
import com.geektech.android3dz2.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApiServices: CharacterApiServices,
    private val characterDao: CharacterDao,
) {

    fun fetchCharacter(status: String, gender: String,
    ): MutableLiveData<RickAndMortyResponse<CharacterModel>> {
        val data: MutableLiveData<RickAndMortyResponse<CharacterModel>> = MutableLiveData()
        characterApiServices.fetchCharacter(status, gender)
            .enqueue(object : retrofit2.Callback<RickAndMortyResponse<CharacterModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    response: Response<RickAndMortyResponse<CharacterModel>>,
                ) {
                    if (response.body() != null) {
                        response.body().let {
                            it?.let { it1 -> characterDao.insertAll(it1.result) }
                        }
                    }
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    t: Throwable,
                ) {
                    data.value = null
                }
            })
        return data
    }

//    fun fetchCharacter(status: String, gender: String): Flow<PagingData<CharacterModel>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = 10,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = {
//                CharacterPagingSource(App.characterApiServices!!, status, gender)
//            }).flow
//    }

    fun fetchCharacterDetail(id: Int): MutableLiveData<CharacterModel> {
        val data: MutableLiveData<CharacterModel> = MutableLiveData()
        characterApiServices.fetchCharactersDetail(id)
            .enqueue(object : retrofit2.Callback<CharacterModel> {
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

    fun getAll(): LiveData<List<CharacterModel>> {
        return characterDao.getAll()
    }
}