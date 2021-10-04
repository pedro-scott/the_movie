package com.github.pedroscott.movies_feature.feature.home.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.github.pedroscott.movies_feature.base.BaseViewModel
import com.github.pedroscott.movies_feature.feature.home.data.model.NowPlayResult
import com.github.pedroscott.movies_feature.feature.home.data.paging.HomePagingSource
import com.github.pedroscott.movies_feature.feature.home.domain.HomeUseCase
import com.github.pedroscott.movies_feature.utils.Constants.TmdbApi.PAGE_SIZE
import kotlinx.coroutines.flow.Flow

class HomeViewModel(
    private val homeUseCase: HomeUseCase
) : BaseViewModel() {

    var isCreated = false
        private set

    fun notifyThatIsCreated() { isCreated = true }

    fun getNowPlayingMovies(): Flow<PagingData<NowPlayResult>> =
        Pager(
            PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false,
                maxSize = 80
            )
        ) {
            HomePagingSource(homeUseCase)
        }.flow.cachedIn(viewModelScope)
}