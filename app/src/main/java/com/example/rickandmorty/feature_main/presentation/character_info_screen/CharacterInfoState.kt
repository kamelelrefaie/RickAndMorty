package com.example.rickandmorty.feature_main.presentation.character_info_screen

import com.example.rickandmorty.feature_main.domain.model.CharacterInfo

data class CharacterInfoState(
    val isLoading: Boolean = false,
    val characterInfo: CharacterInfo? = null,
    val error: String = ""
)
