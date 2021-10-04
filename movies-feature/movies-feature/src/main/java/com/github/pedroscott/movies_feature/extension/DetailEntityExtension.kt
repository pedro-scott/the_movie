package com.github.pedroscott.movies_feature.extension

import com.github.pedroscott.movies_feature.db.entity.DetailEntity
import com.github.pedroscott.movies_feature.feature.detail.data.model.DetailsViewParams
import com.github.pedroscott.movies_feature.feature.favorite.data.model.FavoriteViewParams

fun DetailEntity.toDetailsViewParams() =
    DetailsViewParams(
        backdropPath,
        posterPath,
        genres,
        detailId,
        overview,
        popularity,
        releaseDate,
        title,
        voteAverage
    )

fun DetailEntity.toFavoriteViewParams() =
    FavoriteViewParams(
        posterPath,
        id,
        detailId,
        voteAverage.take(3)
    )