package com.github.pedroscott.movies_feature.feature.detail.data.model

import androidx.recyclerview.widget.DiffUtil

data class SimilarResultViewParams(
    var genres: String,
    val id: Int,
    val releaseDate: String,
    var posterPath: String?,
    val title: String
) {
    companion object {
        val DIFF_SIMILAR_RESULT_VIEW_PARAMS = object : DiffUtil.ItemCallback<SimilarResultViewParams>() {
            override fun areItemsTheSame(
                oldItem: SimilarResultViewParams,
                newItem: SimilarResultViewParams
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: SimilarResultViewParams,
                newItem: SimilarResultViewParams
            ): Boolean = oldItem.id == newItem.id
        }
    }
}