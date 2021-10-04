package com.github.pedroscott.movies_feature.feature.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.pedroscott.movies_feature.databinding.NowPlayingItemBinding
import com.github.pedroscott.movies_feature.feature.favorite.data.model.FavoriteViewParams
import com.github.pedroscott.movies_feature.feature.favorite.data.model.FavoriteViewParams.Companion.DIFF_FAVORITE_RESULT

class FavoriteAdapter(
    private val onClick: (id: Int) -> Unit
) : ListAdapter<FavoriteViewParams, FavoriteViewHolder>(DIFF_FAVORITE_RESULT) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder =
        LayoutInflater.from(parent.context).let { inflater ->
            NowPlayingItemBinding.inflate(inflater, parent, false).let { binding ->
                FavoriteViewHolder(binding)
            }
        }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) =
        getItem(position)?.let { result ->
            holder.bind(result, onClick)
        } ?: Unit
}

class FavoriteViewHolder(
    private val binding: NowPlayingItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(favorite: FavoriteViewParams, onClick: (id: Int) -> Unit) {
        with(binding) {
            with(favorite) {
                Glide.with(itemView.context)
                    .load(posterPath)
                    .into(ivNowPlayingPoster)

                tvNowPlayingAverage.text = voteAverage

                cvNowPlayinLayout.setOnClickListener {
                    onClick(movieId)
                }
            }
        }
    }
}