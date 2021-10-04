package com.github.pedroscott.movies_feature.feature.home.domain

import com.github.pedroscott.movies_feature.extension.getFullImageUrl
import com.github.pedroscott.movies_feature.feature.home.data.model.NowPlayResult
import com.github.pedroscott.movies_feature.feature.home.data.model.NowPlaying
import com.github.pedroscott.movies_feature.feature.home.data.repository.HomeRepository
import com.github.pedroscott.movies_feature.utils.ResponseApi

class HomeUseCase(
    private val homeRepository: HomeRepository
) {

    suspend fun getNowPlayingResult(page: Int): List<NowPlayResult> =
        homeRepository.getNowPlayingMovies(page).let { response ->
            when(response) {
                is ResponseApi.Success -> {
                    (response.data as? NowPlaying)?.let { nowPlaying ->
                        nowPlaying.results.filter { result1 ->
                               result1.posterPath != null
                               && result1.backdropPath != null
                               && result1.overview != null
                               && result1.overview != ""
                        }.map { result2 ->
                            result2.apply {
                                posterPath = posterPath?.getFullImageUrl(200)
                            }
                        }
                    } ?: listOf()
                }

                is ResponseApi.Error -> listOf()
            }
        }
}