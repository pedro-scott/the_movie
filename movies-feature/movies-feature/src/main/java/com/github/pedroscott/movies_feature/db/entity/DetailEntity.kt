package com.github.pedroscott.movies_feature.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detail_movies")
data class DetailEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "detail_id") val detailId: Int,
    @ColumnInfo(name = "backdrop_path") val backdropPath: String?,
    @ColumnInfo(name = "poster_path") val posterPath: String?,
    val genres: String,
    val overview: String?,
    val popularity: String,
    @ColumnInfo(name = "release_date") val releaseDate: String,
    val title: String,
    @ColumnInfo(name = "vote_average") val voteAverage: String
)