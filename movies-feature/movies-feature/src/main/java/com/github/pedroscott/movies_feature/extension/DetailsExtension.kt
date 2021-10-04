package com.github.pedroscott.movies_feature.extension

import com.github.pedroscott.movies_feature.feature.detail.data.model.Details
import com.github.pedroscott.movies_feature.feature.detail.data.model.DetailsViewParams

fun Details.toDetailsViewParams(): DetailsViewParams =
    DetailsViewParams(
        backdropPath,
        posterPath,
        genres.getMovieGenres(),
        id,
        overview,
        popularity.getViewsFormat(),
        releaseDate.getDateBrFormat(),
        title,
        voteAverage.getStarsFormat()
    )