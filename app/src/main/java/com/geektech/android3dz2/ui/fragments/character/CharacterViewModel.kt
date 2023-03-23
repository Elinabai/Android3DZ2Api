package com.geektech.android3dz2.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.geektech.android3dz2.data.repoitories.CharacterRepository
import com.geektech.android3dz2.model.CharacterModel
import kotlinx.coroutines.launch

class CharacterViewModel: ViewModel() {

    private var characterRepository = CharacterRepository()
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

