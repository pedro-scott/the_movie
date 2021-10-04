package com.github.pedroscott.movies_feature.feature.home.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.pedroscott.movies_feature.feature.home.data.model.NowPlayResult
import com.github.pedroscott.movies_feature.feature.home.domain.HomeUseCase
import com.github.pedroscott.movies_feature.utils.Constants.TmdbApi.FIRST_PAGE
import java.lang.Exception

class HomePagingSource(
    private val homeUseCase: HomeUseCase
) : PagingSource<Int, NowPlayResult>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NowPlayResult> =
        try {
            val page = params.key ?: FIRST_PAGE

            callNowPlaying(page).let { listResults ->
                val nextPage =
                    if (listResults.isEmpty())
                        null
                    else
                        page + 1

                val prevPage =
                    if (page == FIRST_PAGE)
                        null
                    else
                        page - 1

                LoadResult.Page(
                    listResults,
                    prevPage,
                    nextPage
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    override fun getRefreshKey(state: PagingState<Int, NowPlayResult>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)

            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    private suspend fun callNowPlaying(page: Int) : List<NowPlayResult> =
        homeUseCase.getNowPlayingResult(page)
}