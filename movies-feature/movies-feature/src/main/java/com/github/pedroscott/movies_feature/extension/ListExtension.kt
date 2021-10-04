package com.github.pedroscott.movies_feature.extension

import com.github.pedroscott.movies_feature.db.entity.DetailEntity
import com.github.pedroscott.movies_feature.db.entity.SimilarEntity
import com.github.pedroscott.movies_feature.feature.detail.data.model.Genre
import com.github.pedroscott.movies_feature.feature.detail.data.model.SimilarResult
import com.github.pedroscott.movies_feature.feature.detail.data.model.SimilarResultViewParams
import com.github.pedroscott.movies_feature.feature.favorite.data.model.FavoriteViewParams

fun List<Genre>.getMovieGenres() : String {
    var genres = ""

    this.forEachIndexed { i, genre ->
        if (i <= 2) {
            genres += genre.name

            if (i < this.size - 1 && i < 2)
                genres += ", "
        }
    }

    return genres
}

fun List<Genre>.getTextGenres() : String {
    var textGenres = ""

    forEach { genreInfo ->
        textGenres += genreInfo.name

        if (genreInfo != this.last())
            textGenres += ", "
    }

    return textGenres
}

@JvmName("toListSimilarResultViewParamsFromResult")
fun List<SimilarResult>.toListSimilarResultViewParams(): List<SimilarResultViewParams> =
    mutableListOf<SimilarResultViewParams>().apply {
        this@toListSimilarResultViewParams.forEach { similarResult ->
            this.add(
                similarResult.toSimilarResultViewParams()
            )
        }
    }

fun List<SimilarResultViewParams>.toListSimilarEntity(detailRelatedId: Int): List<SimilarEntity> =
    mutableListOf<SimilarEntity>().apply {
        this@toListSimilarEntity.forEach { viewParams ->
            this.add(
                viewParams.toSimilarEntity(detailRelatedId)
            )
        }
    }

@JvmName("toListSimilarResultViewParamsFromEntity")
fun List<SimilarEntity>.toListSimilarResultViewParams() =
    mutableListOf<SimilarResultViewParams>().apply {
        this@toListSimilarResultViewParams.forEach { similarEntity ->
            this.add(
                similarEntity.toSimilarResultViewParams()
            )
        }
    }

fun List<DetailEntity>.toListFavoriteViewParams(): List<FavoriteViewParams> =
    mutableListOf<FavoriteViewParams>().apply {
        this@toListFavoriteViewParams.forEach { detailEntity ->
            this.add(
                detailEntity.toFavoriteViewParams()
            )
        }
    }
