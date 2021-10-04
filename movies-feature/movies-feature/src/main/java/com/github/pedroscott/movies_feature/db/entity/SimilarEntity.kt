package com.github.pedroscott.movies_feature.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "similar_movies")
data class SimilarEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "similar_id")
    val similarId: Int = 0,
    @ColumnInfo(name = "detail_related_id") val detailRelatedId: Int,
    val genres: String,
    @ColumnInfo(name = "release_date") val releaseDate: String,
    @ColumnInfo(name = "poster_path") val posterPath: String?,
    val title: String
)