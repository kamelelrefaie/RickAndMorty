package com.example.rickandmorty.feature_main.domain.use_case

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmorty.feature_main.common.RickSource
import com.example.rickandmorty.feature_main.domain.model.CharacterInfo
import com.example.rickandmorty.feature_main.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterList @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    operator fun invoke(): Flow<PagingData<CharacterInfo>> {

             val character: Flow<PagingData<CharacterInfo>> = Pager(PagingConfig(pageSize = 10)) {
               RickSource(repository = repository)
           }.flow.cachedIn(scope = CoroutineScope(Dispatchers.IO))

        return character

    }
}