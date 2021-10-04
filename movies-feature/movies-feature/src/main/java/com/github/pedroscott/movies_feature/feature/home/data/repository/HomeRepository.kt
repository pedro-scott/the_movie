package com.github.pedroscott.movies_feature.feature.home.data.repository

import com.github.pedroscott.movies_feature.utils.ResponseApi

interface HomeRepository {
    suspend fun getNowPlayingMovies(page: Int): ResponseApi
}