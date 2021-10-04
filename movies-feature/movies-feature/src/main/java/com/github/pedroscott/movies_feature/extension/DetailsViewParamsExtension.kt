package com.github.pedroscott.movies_feature.extension

import com.github.pedroscott.movies_feature.db.entity.DetailEntity
import com.github.pedroscott.movies_feature.feature.detail.data.model.DetailsViewParams

fun DetailsViewParams.toDetailEntity(): DetailEntity =
    DetailEntity(
        detailId = id,
        backdropPath = backdropPath,
        posterPath = posterPath,
        genres = genres,
        overview = overview,
        popularity = popularity,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage
    )