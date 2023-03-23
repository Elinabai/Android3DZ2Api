package com.geektech.android3dz2.ui.fragments.character.filter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geektech.android3dz2.data.repoitories.CharacterRepository
import com.geektech.android3dz2.ui.fragments.character.CharacterViewModel

@Suppress("UNCHECKED_CAST")
class CharacterViewModelFactory(private val characterRepository: CharacterRepository):
    ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CharacterViewModel(characterRepository) as T
        }
}