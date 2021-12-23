package com.example.rickandmorty.feature_main.domain.use_case

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import coil.network.HttpException
import com.example.rickandmorty.feature_main.common.Resource
import com.example.rickandmorty.feature_main.common.RickSource
import com.example.rickandmorty.feature_main.data.remote.dto.toCharacterInfo
import com.example.rickandmorty.feature_main.domain.model.CharacterInfo
import com.example.rickandmorty.feature_main.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject


class GetCharacterInfo @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    operator fun invoke(characterId: Int): Flow<Resource<CharacterInfo>> {
        val mainFlow = flow {
            try {
                emit(Resource.Loading<CharacterInfo>())
                val characterInfo = repository.getCharacterInfo(characterId).toCharacterInfo()
                emit(Resource.Success<CharacterInfo>(characterInfo))
            } catch (e: HttpException) {
                emit(Resource.Error<CharacterInfo>(e.localizedMessage ?: "An unexpected error occured"))
            } catch (e: IOException) {
                emit(Resource.Error<CharacterInfo>("Couldn't reach server. Check your internet connection."))
            }

        }

        return mainFlow

    }
}