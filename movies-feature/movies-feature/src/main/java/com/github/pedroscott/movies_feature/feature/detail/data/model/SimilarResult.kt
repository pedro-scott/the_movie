package com.github.pedroscott.movies_feature.feature.detail.data.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class SimilarResult(
    @SerializedName("genre_ids")
    var genreIds: List<Int>,
    val id: Int,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    var posterPath: String?,
    val title: String
)