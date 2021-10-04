package com.github.pedroscott.movies_feature.feature.detail.data.model

import com.google.gson.annotations.SerializedName

data class Details(
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    @SerializedName("poster_path")
    var posterPath: String?,
    val genres: List<Genre>,
    val id: Int,
    val overview: String?,
    val popularity: Double,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double
)