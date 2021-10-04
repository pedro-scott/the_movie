package com.github.pedroscott.movies_feature.feature.favorite.data.model

import androidx.recyclerview.widget.DiffUtil

data class FavoriteViewParams(
    var posterPath: String?,
    val id: Int,
    val movieId: Int,
    val voteAverage: String
) {

    companion object {
        val DIFF_FAVORITE_RESULT = object : DiffUtil.ItemCallback<FavoriteViewParams>() {
            override fun areItemsTheSame(
                oldItem: FavoriteViewParams,
                newItem: FavoriteViewParams
            ): Boolean = oldItem.movieId == newItem.movieId

            override fun areContentsTheSame(
                oldItem: FavoriteViewParams,
                newItem: FavoriteViewParams
            ): Boolean = oldItem.movieId == newItem.movieId
        }
    }
}
