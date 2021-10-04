package com.github.pedroscott.movies_feature.extension

import com.github.pedroscott.movies_feature.feature.detail.data.model.Genre
import com.github.pedroscott.movies_feature.feature.detail.data.model.SimilarResult
import com.github.pedroscott.movies_feature.feature.detail.data.model.SimilarResultViewParams
import com.github.pedroscott.movies_feature.utils.GenresCache

fun SimilarResult.toSimilarResultViewParams() =
    SimilarResultViewParams(
        getListGenres().getTextGenres(),
        id,
        releaseDate.getYear(),
        posterPath,
        title
    )

fun SimilarResult.getListGenres() : MutableList<Genre> =
    mutableListOf<Genre>().apply {
        genreIds.forEach { genreId ->
            GenresCache.genresCached?.genres?.find { genre ->
                genre.id == genreId
            }?.let { genre ->
                add(genre)
            }
        }
    }