//package com.geektech.android3dz2.data.repoitories.pagingsources
//
//import android.net.Uri
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.geektech.android3dz2.data.network.apiservices.LocationApiServices
//import com.geektech.android3dz2.model.LocationModel
//import okio.IOException
//import retrofit2.HttpException
//
//private const val LOCATION_STARTING_PAGE_INDEX = 1
//
//class LocationPagingSource(private val service: LocationApiServices) :
//    PagingSource<Int, LocationModel>() {
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationModel> {
//        val position = params.key ?: LOCATION_STARTING_PAGE_INDEX
//        return try {
//            val response = service.fetchLocation(position)
//            val nextPageNumber = Uri.parse(response.info.next).getQueryParameter("page")!!.toInt()
//            LoadResult.Page(
//                data = response.result,
//                prevKey = null,
//                nextKey = nextPageNumber
//            )
//        } catch (exception: IOException) {
//            return LoadResult.Error(exception)
//        } catch (exception: HttpException) {
//            return LoadResult.Error(exception)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, LocationModel>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
//        }
//    }
//}