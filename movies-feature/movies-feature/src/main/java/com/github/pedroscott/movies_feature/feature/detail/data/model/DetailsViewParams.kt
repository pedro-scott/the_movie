package com.github.pedroscott.movies_feature.feature.detail.data.model

data class DetailsViewParams(
    val backdropPath: String?,
    val posterPath: String?,
    val genres: String,
    val id: Int,
    val overview: String?,
    val popularity: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: String
)