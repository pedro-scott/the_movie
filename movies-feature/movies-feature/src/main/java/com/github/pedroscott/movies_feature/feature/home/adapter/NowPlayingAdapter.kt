package com.github.pedroscott.movies_feature.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.pedroscott.movies_feature.databinding.NowPlayingItemBinding
import com.github.pedroscott.movies_feature.feature.home.data.model.NowPlayResult
import com.github.pedroscott.movies_feature.feature.home.data.model.NowPlayResult.Companion.DIFF_NOW_PLAY_RESULT

class NowPlayingAdapter(
    private val onClick: (id: Int) -> Unit
) : PagingDataAdapter<NowPlayResult, NowPlayingViewHolder>(DIFF_NOW_PLAY_RESULT) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingViewHolder =
        LayoutInflater.from(parent.context).let { inflater ->
            NowPlayingItemBinding.inflate(inflater, parent, false).let { binding ->
                NowPlayingViewHolder(binding)
            }
        }

    override fun onBindViewHolder(holder: NowPlayingViewHolder, position: Int) =
        getItem(position)?.let { result ->
            holder.bind(result, onClick)
        } ?: Unit
}

class NowPlayingViewHolder(
    private val binding: NowPlayingItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(result: NowPlayResult, onClick: (id: Int) -> Unit) {
        with(binding) {
            with(result) {
                Glide.with(itemView.context)
                    .load(posterPath)
                    .into(ivNowPlayingPoster)

                tvNowPlayingAverage.text = voteAverage.toString()

                cvNowPlayinLayout.setOnClickListener {
                    onClick(id)
                }
            }
        }
    }
}