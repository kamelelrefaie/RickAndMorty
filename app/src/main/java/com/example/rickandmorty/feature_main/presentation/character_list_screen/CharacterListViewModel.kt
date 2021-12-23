package com.example.rickandmorty.feature_main.presentation.character_list_screen

import androidx.lifecycle.ViewModel
import com.example.rickandmorty.feature_main.domain.use_case.GetCharacterList
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(getCharacterList: GetCharacterList) : ViewModel() {
    val characterList = getCharacterList()
}