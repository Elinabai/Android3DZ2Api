package com.geektech.android3dz2.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.geektech.android3dz2.data.repoitories.CharacterRepository
import com.geektech.android3dz2.model.CharacterModel
import kotlinx.coroutines.launch

class CharacterViewModel(private val characterRepository: CharacterRepository) : ViewModel(),
    ViewModelProvider.Factory {

    val filterValue = MutableLiveData<PagingData<CharacterModel>>()

    fun fetchCharacter(status: String, gender: String) {
        viewModelScope.launch {
            characterRepository.fetchCharacter(status, gender).cachedIn(viewModelScope).collect {
                filterValue.value = it
            }
        }
    }

    fun fetchCharacterDetail(id: Int): MutableLiveData<CharacterModel> {
        return characterRepository.fetchCharacterDetail(id)
    }
}

