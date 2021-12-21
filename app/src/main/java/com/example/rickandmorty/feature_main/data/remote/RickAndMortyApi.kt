package com.example.rickandmorty.feature_main.data.remote

import com.example.rickandmorty.feature_main.common.Constants
import com.example.rickandmorty.feature_main.data.remote.dto.CharacterInfoDto
import com.example.rickandmorty.feature_main.data.remote.dto.CharacterListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacterList(@Query("page") page: Int): CharacterListDto

    @GET("/character/{${Constants.CHARACTER_ID}}")
    suspend fun getCoinById(@Path(Constants.CHARACTER_ID) characterId: String): CharacterInfoDto
}