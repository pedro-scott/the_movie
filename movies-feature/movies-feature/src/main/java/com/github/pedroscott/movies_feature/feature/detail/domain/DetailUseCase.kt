package com.github.pedroscott.movies_feature.feature.detail.domain

import com.github.pedroscott.movies_feature.db.entity.DetailsWithSimilar
import com.github.pedroscott.movies_feature.extension.*
import com.github.pedroscott.movies_feature.feature.detail.data.model.Details
import com.github.pedroscott.movies_feature.feature.detail.data.model.DetailsViewParams
import com.github.pedroscott.movies_feature.feature.detail.data.model.Similar
import com.github.pedroscott.movies_feature.feature.detail.data.model.SimilarResultViewParams
import com.github.pedroscott.movies_feature.feature.detail.data.repository.DetailRepository
import com.github.pedroscott.movies_feature.utils.ResponseApi

class DetailUseCase(
    private val detailRepository: DetailRepository
) {

    suspend fun getMovieDetails(movieId: Int): ResponseApi =
        detailRepository.getMovieDetails(movieId).let { response ->
            when (response) {
                is ResponseApi.Success -> {
                    (response.data as Details).let { details ->
                        details.backdropPath = details.backdropPath?.getFullImageUrl(500)
                        details.posterPath = details.posterPath?.getFullImageUrl(200)

                        ResponseApi.Success(details)
                    }
                }

                is ResponseApi.Error -> response
            }
        }

    suspend fun getSimilarMovies(movieId: Int): ResponseApi =
        detailRepository.getSimilarMovies(movieId).let { response ->
            when (response) {
                is ResponseApi.Success -> {
                    (response.data as Similar).let { similar ->
                        similar.results
                            .take(5)
                            .filter { result1 ->
                                result1.posterPath != null
                            }.map { result2 ->
                                result2.apply {
                                    posterPath = posterPath?.getFullImageUrl(200)
                                    if (genreIds.size > 3)
                                        genreIds = genreIds.take(3)
                                }
                            }.let { resultList ->
                                ResponseApi.Success(resultList)
                            }
                    }
                }

                is ResponseApi.Error -> response
            }
        }

    suspend fun getGenresMovies(): ResponseApi =
        detailRepository.getGenresMovies()

    suspend fun verifyFavorite(movieId: Int): Boolean =
        detailRepository.verifyFavorite(movieId)?.let {
            true
        } ?: false

    suspend fun insertDetailsMovies(details: DetailsViewParams) =
        detailRepository.insertDetailsMovies(details.toDetailEntity())

    suspend fun insertAllSimilarMovies(
        detailRelatedId: Int,
        similarMovies: List<SimilarResultViewParams>
    ) =
        detailRepository.insertAllSimilarMovies(similarMovies.toListSimilarEntity(detailRelatedId))

    suspend fun deleteDetails(movieId: Int) =
        detailRepository.deleteDetails(movieId)

    suspend fun deleteSimilarMovies(movieRelatedId: Int) =
        detailRepository.deleteSimilarMovies(movieRelatedId)

    suspend fun getDetailsWithSimilarMovies(movieId: Int): DetailsWithSimilar =
        detailRepository.getDetailsWithSimilarMovies(movieId)
}