package com.github.pedroscott.movies_feature.extension

import com.github.pedroscott.movies_feature.db.entity.SimilarEntity
import com.github.pedroscott.movies_feature.feature.detail.data.model.SimilarResultViewParams

fun SimilarResultViewParams.toSimilarEntity(detailRelatedId: Int) =
    SimilarEntity(
        detailRelatedId = detailRelatedId,
        genres = genres,
        releaseDate = releaseDate,
        posterPath = posterPath,
        title = title
    )