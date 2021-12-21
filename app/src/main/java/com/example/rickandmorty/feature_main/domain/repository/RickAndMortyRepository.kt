package com.example.rickandmorty.feature_main.domain.repository

import com.example.rickandmorty.feature_main.data.remote.dto.CharacterInfoDto
import com.example.rickandmorty.feature_main.data.remote.dto.CharacterListDto

interface RickAndMortyRepository {

    suspend fun getCharactersList(page: Int): CharacterListDto
    suspend fun getCharacterInfo(characterId: String): CharacterInfoDto
}