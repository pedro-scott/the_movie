package com.github.pedroscott.movies_feature.feature.detail.data.repository

import com.github.pedroscott.movies_feature.api.ApiService
import com.github.pedroscott.movies_feature.base.BaseRepository
import com.github.pedroscott.movies_feature.db.entity.DetailEntity
import com.github.pedroscott.movies_feature.db.FavoriteDao
import com.github.pedroscott.movies_feature.db.entity.DetailsWithSimilar
import com.github.pedroscott.movies_feature.db.entity.SimilarEntity
import com.github.pedroscott.movies_feature.utils.ResponseApi

class DetailRepositoryImp(
    private val favoriteDao: FavoriteDao
) : BaseRepository(), DetailRepository {

    override suspend fun getMovieDetails(movieId: Int): ResponseApi =
        safeApiCall {
            ApiService.tmdbApi.getMovieDetails(movieId)
        }

    override suspend fun getSimilarMovies(movieId: Int): ResponseApi =
        safeApiCall {
            ApiService.tmdbApi.getSimilarMovies(movieId)
        }

    override suspend fun getGenresMovies(): ResponseApi =
        safeApiCall {
            ApiService.tmdbApi.getGenresMovies()
        }

    override suspend fun verifyFavorite(movieId: Int): DetailEntity? = favoriteDao.verifyFavorite(movieId)

    override suspend fun insertDetailsMovies(details: DetailEntity) = favoriteDao.insertDetailsMovies(details)

    override suspend fun insertAllSimilarMovies(similarMovies: List<SimilarEntity>) = favoriteDao.insertAllSimilarMovies(similarMovies)

    override suspend fun deleteDetails(movieId: Int) = favoriteDao.deleteDetails(movieId)

    override suspend fun deleteSimilarMovies(movieRelatedId: Int) = favoriteDao.deleteSimilarMovies(movieRelatedId)

    override suspend fun getDetailsWithSimilarMovies(movieId: Int): DetailsWithSimilar = favoriteDao.getDetailsWithSimilarMovies(movieId)
}