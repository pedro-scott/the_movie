package com.github.pedroscott.movies_feature.feature.home.data.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class NowPlayResult(
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    @SerializedName("poster_path")
    var posterPath: String?,
    val id: Int,
    @SerializedName("vote_average")
    val voteAverage: Double,
    val overview: String?
) {

    companion object {
        val DIFF_NOW_PLAY_RESULT = object : DiffUtil.ItemCallback<NowPlayResult>() {
            override fun areItemsTheSame(
                oldItem: NowPlayResult,
                newItem: NowPlayResult
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: NowPlayResult,
                newItem: NowPlayResult
            ): Boolean = oldItem.id == newItem.id
        }
    }
}