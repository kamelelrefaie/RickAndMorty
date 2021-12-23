package com.example.rickandmorty.feature_main.presentation.character_info_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.feature_main.common.Constants
import com.example.rickandmorty.feature_main.common.Resource
import com.example.rickandmorty.feature_main.domain.repository.RickAndMortyRepository
import com.example.rickandmorty.feature_main.domain.use_case.GetCharacterInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterInfoViewModel @Inject constructor(
    private val getCharacterInfo: GetCharacterInfo,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CharacterInfoState())
    val state: State<CharacterInfoState> = _state

    init {
        savedStateHandle.get<Int>(Constants.CHARACTER_ID)?.let { charId ->
            getCharacter(charId)

        }
    }

    private fun getCharacter(characterId: Int) {
        getCharacterInfo(characterId = characterId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CharacterInfoState(characterInfo = result.data)
                }
                is Resource.Error -> {
                    _state.value = CharacterInfoState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CharacterInfoState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}