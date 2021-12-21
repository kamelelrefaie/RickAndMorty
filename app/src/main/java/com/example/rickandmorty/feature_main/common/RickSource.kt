package com.example.rickandmorty.feature_main.common

import androidx.paging.PagingSource
import androidx.paging.PagingState
import coil.network.HttpException
import com.example.rickandmorty.feature_main.data.remote.dto.toCharacterInfo
import com.example.rickandmorty.feature_main.domain.model.CharacterInfo
import com.example.rickandmorty.feature_main.domain.repository.RickAndMortyRepository
import okio.IOException
import javax.inject.Inject

class RickSource @Inject constructor(private val repository: RickAndMortyRepository) :
    PagingSource<Int, CharacterInfo>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterInfo>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterInfo> {

        return try {
            val nextPage = params.key ?: 1
            val charList = repository.getCharactersList(nextPage)
            LoadResult.Page(
                data = charList.results.map { it.toCharacterInfo() },
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (charList.results.isEmpty()) null else nextPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}