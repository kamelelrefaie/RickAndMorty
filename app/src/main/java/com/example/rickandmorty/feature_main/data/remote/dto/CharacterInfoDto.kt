package com.example.rickandmorty.feature_main.data.remote.dto

import com.example.rickandmorty.feature_main.domain.model.CharacterInfo

data class CharacterInfoDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterInfoDto.toCharacterInfo(): CharacterInfo {
    return CharacterInfo(
        id = id,
        image = image,
        name = name,
        status = status,
        gender = gender
    )
}