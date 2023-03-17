package com.geektech.android3dz2.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.android3dz2.data.repoitories.CharacterRepository
import com.geektech.android3dz2.model.CharacterModel
import com.geektech.android3dz2.model.RickAndMortyResponse

class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()

    fun fetchCharacter(): MutableLiveData<RickAndMortyResponse<CharacterModel>> {
        return characterRepository.fetchCharacter()
    }

    fun fetchCharacterDetail(id: Int): MutableLiveData<CharacterModel> {
        return characterRepository.fetchCharacterDetail(id)
    }
}