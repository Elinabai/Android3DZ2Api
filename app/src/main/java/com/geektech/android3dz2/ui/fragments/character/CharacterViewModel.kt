package com.geektech.android3dz2.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.geektech.android3dz2.data.repoitories.CharacterRepository
import com.geektech.android3dz2.model.CharacterModel

class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()

    fun fetchCharacter() = characterRepository.fetchCharacter().cachedIn(viewModelScope)

    fun fetchCharacterDetail(id: Int): MutableLiveData<CharacterModel> {
        return characterRepository.fetchCharacterDetail(id)
    }
}