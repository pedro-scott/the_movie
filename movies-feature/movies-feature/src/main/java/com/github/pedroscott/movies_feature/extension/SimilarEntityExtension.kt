package com.github.pedroscott.movies_feature.extension

import com.github.pedroscott.movies_feature.db.entity.SimilarEntity
import com.github.pedroscott.movies_feature.feature.detail.data.model.SimilarResultViewParams

fun SimilarEntity.toSimilarResultViewParams() =
    SimilarResultViewParams(
        genres,
        similarId,
        releaseDate,
        posterPath,
        title
    )