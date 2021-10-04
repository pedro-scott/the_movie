package com.github.pedroscott.movies_feature.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class DetailsWithSimilar(
    @Embedded val details: DetailEntity,
    @Relation(
        parentColumn = "detail_id",
        entityColumn = "detail_related_id"
    )
    val similarMovies: List<SimilarEntity>
)