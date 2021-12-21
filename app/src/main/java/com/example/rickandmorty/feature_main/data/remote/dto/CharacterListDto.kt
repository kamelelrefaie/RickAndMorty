package com.example.rickandmorty.feature_main.data.remote.dto

data class CharacterListDto(
    val info: Info,
    val results: List<CharacterInfoDto>
)