package com.geektech.android3dz2.data.repoitories.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.geektech.android3dz2.data.network.apiservices.CharacterApiServices
import com.geektech.android3dz2.model.CharacterModel
import okio.IOException
import retrofit2.HttpException

private const val CHARACTER_STARTING_PAGE_INDEX = 1

class CharacterPagingSource(private val service: CharacterApiServices) :
    PagingSource<Int, CharacterModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        val position = params.key ?: CHARACTER_STARTING_PAGE_INDEX
        return try {
            val response = service.fetchCharacter(position)
            val nextPageNumber = Uri.parse(response.info.next).getQueryParameter("page")!!.toInt()
            LoadResult.Page(
                data = response.result,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}