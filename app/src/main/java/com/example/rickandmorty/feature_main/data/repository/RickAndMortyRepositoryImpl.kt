package com.example.rickandmorty.feature_main.data.repository

import com.example.rickandmorty.feature_main.data.remote.RickAndMortyApi
import com.example.rickandmorty.feature_main.data.remote.dto.CharacterInfoDto
import com.example.rickandmorty.feature_main.data.remote.dto.CharacterListDto
import com.example.rickandmorty.feature_main.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
) :
    RickAndMortyRepository {

    override suspend fun getCharactersList(page: Int): CharacterListDto {
        return api.getCharacterList(page = page)
    }


    override suspend fun getCharacterInfo(characterId: Int): CharacterInfoDto {
        return api.getCharacterById(charId = characterId)
    }
}