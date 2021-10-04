package com.github.pedroscott.movies_feature.feature.home.data.repository

import com.github.pedroscott.movies_feature.api.ApiService
import com.github.pedroscott.movies_feature.base.BaseRepository
import com.github.pedroscott.movies_feature.utils.ResponseApi

class HomeRepositoryImp : BaseRepository(), HomeRepository {

    override suspend fun getNowPlayingMovies(page: Int): ResponseApi =
        safeApiCall {
            ApiService.tmdbApi.getNowPlayngMovies(page)
        }
}