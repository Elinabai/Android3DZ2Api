package com.geektech.android3dz2.ui.fragments.character

import androidx.lifecycle.ViewModel
import com.geektech.android3dz2.data.repoitories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private var characterRepository: CharacterRepository,
) : ViewModel() {

    fun fetchCharacter(status: String, gender: String) =
        characterRepository.fetchCharacter(status, gender)

    fun getAll() = characterRepository.getAll()
}