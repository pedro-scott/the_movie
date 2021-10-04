package com.github.pedroscott.movies_feature.feature.detail.data.repository

import com.github.pedroscott.movies_feature.db.entity.DetailEntity
import com.github.pedroscott.movies_feature.db.entity.DetailsWithSimilar
import com.github.pedroscott.movies_feature.db.entity.SimilarEntity
import com.github.pedroscott.movies_feature.utils.ResponseApi

interface DetailRepository {

    suspend fun getMovieDetails(movieId: Int): ResponseApi
    suspend fun getSimilarMovies(movieId: Int): ResponseApi
    suspend fun getGenresMovies(): ResponseApi

    suspend fun verifyFavorite(movieId: Int): DetailEntity?

    suspend fun insertDetailsMovies(details: DetailEntity)
    suspend fun insertAllSimilarMovies(similarMovies: List<SimilarEntity>)

    suspend fun deleteDetails(movieId: Int)
    suspend fun deleteSimilarMovies(movieRelatedId: Int)

    suspend fun getDetailsWithSimilarMovies(movieId: Int): DetailsWithSimilar
}