package com.github.pedroscott.movies_feature.feature.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.pedroscott.movies_feature.databinding.SimilarMovieItemBinding
import com.github.pedroscott.movies_feature.extension.getYear
import com.github.pedroscott.movies_feature.feature.detail.data.model.SimilarResultViewParams
import com.github.pedroscott.movies_feature.feature.detail.data.model.SimilarResultViewParams.Companion.DIFF_SIMILAR_RESULT_VIEW_PARAMS

class DetailAdapter : ListAdapter<SimilarResultViewParams, DetailViewHolder>(DIFF_SIMILAR_RESULT_VIEW_PARAMS) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder =
        LayoutInflater.from(parent.context).let { inflater ->
            SimilarMovieItemBinding.inflate(inflater, parent, false).let { binding ->
                DetailViewHolder(binding)
            }
        }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        getItem(position)?.let { result ->
            holder.bind(result)
        }
    }
}

class DetailViewHolder(
    private val binding: SimilarMovieItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(result: SimilarResultViewParams) {
        with(binding) {
            with(result) {
                Glide.with(itemView.context)
                    .load(posterPath)
                    .into(ivSimilarItemPoster)

                tvSimilarItemTitle.text = title
                tvSimilarItemReleaseYear.text = releaseDate
                tvSimilarItemGenres.text = genres
            }
        }
    }
}