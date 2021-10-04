package com.github.pedroscott.movies_feature.feature.detail.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.github.pedroscott.movies_feature.databinding.FragmentDetailBinding
import com.github.pedroscott.movies_feature.extension.*
import com.github.pedroscott.movies_feature.feature.detail.adapter.DetailAdapter
import com.github.pedroscott.movies_feature.feature.detail.data.model.DetailsViewParams
import com.github.pedroscott.movies_feature.feature.detail.data.model.SimilarResultViewParams
import com.github.pedroscott.movies_feature.feature.detail.presentation.viewmodel.DetailViewModel
import com.github.pedroscott.movies_feature.utils.Command
import com.github.pedroscott.movies_feature.utils.GenresCache
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {
    private var binding: FragmentDetailBinding? = null
    private val detailViewModel: DetailViewModel by viewModel()
    private val command: MutableLiveData<Command> by lazy {
        MutableLiveData<Command>()
    }

    private val adapter: DetailAdapter by lazy {
        DetailAdapter()
    }

    private val movieId by lazy {
        navArgs<DetailFragmentArgs>().value.movieId
    }

    private val loadFromDatabase: Boolean by lazy {
        navArgs<DetailFragmentArgs>().value.loadFromDatabase
    }

    private lateinit var detailsViewParams: DetailsViewParams
    private lateinit var similarMovies: List<SimilarResultViewParams>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        setupButtonBack()
        setupRecyclerView()

        return binding?.root
    }

    private fun setupButtonBack() {
        binding?.run {
            tapDetailFragAppBar.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    private fun setupRecyclerView() {
        binding?.run {
            context?.let { contextNonNull ->
                rvDetailsFragSimilarMovies.adapter = adapter
                rvDetailsFragSimilarMovies.layoutManager = LinearLayoutManager(contextNonNull)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel.command = command

        setupObservables()
        verifyFavorite()
        setupButtonFavorite()

        if (loadFromDatabase) {
            loadDetailsFromDatabase()
        } else {
            GenresCache.genresCached ?: loadGenres()
            loadMovieDetails()
            loadSimilarMovies()
        }

        setupClickRetry()
    }

    private fun setupObservables() {
        detailViewModel.onSuccessMovieDetails.observe(viewLifecycleOwner) { details ->
            detailsViewParams = details.toDetailsViewParams()
            setupLayout(detailsViewParams)
        }

        detailViewModel.onSuccessSimilarMovies.observe(viewLifecycleOwner) { listResult ->
            similarMovies = listResult.toListSimilarResultViewParams()
            adapter.submitList(similarMovies)
        }

        detailViewModel.command.observe(viewLifecycleOwner) { command ->
            when (command) {
                is Command.Loading -> {
                    binding?.run {
                        if (command.value)
                            flDetailFragLoading.isVisible = true
                        else {
                            flDetailFragLoading.isVisible = false
                            clDetailFragError.isVisible = false
                        }
                    }
                }

                is Command.Error -> binding?.clDetailFragError?.isVisible = true
            }
        }

        detailViewModel.onSuccessGenresMovies.observe(viewLifecycleOwner) { genres ->
            GenresCache.genresCached = genres
        }

        detailViewModel.onVerifyFavorite.observe(viewLifecycleOwner) { value ->
            binding?.run {
                if (value)
                    btDetailFragFavorite.frame = 25
                else
                    btDetailFragFavorite.frame = 0
            }
        }

        detailViewModel.onSuccessDetailsWithSimilar.observe(viewLifecycleOwner) { detailsWithSimilar ->
            detailsViewParams = detailsWithSimilar.details.toDetailsViewParams()
            similarMovies = detailsWithSimilar.similarMovies.toListSimilarResultViewParams()

            setupLayout(detailsViewParams)
            adapter.submitList(similarMovies)
        }
    }

    private fun setupLayout(details: DetailsViewParams) {
        binding?.run {
            with(details) {
                Glide.with(this@DetailFragment)
                    .load(backdropPath)
                    .into(ivDetailFragPoster)

                tvDetailFragTitle.text = title
                tvDetailFragStars.text = voteAverage
                tvDetailFragViews.text = popularity
                tvDetailFragOverview.text = overview
                tvDetailFragDate.text = releaseDate
                tvDetailFragGenresList.text = genres
            }
        }
    }

    private fun verifyFavorite() {
        detailViewModel.verifyFavorite(movieId)
    }

    private fun setupButtonFavorite() {
        binding?.run {
            with(btDetailFragFavorite) {
                setMaxFrame(25)

                setOnClickListener {
                    if (frame == 25) {
                        deleteFavorite()

                        speed = -3.0F
                        playAnimation()
                    } else {
                        addFavorite()

                        speed = 3.0F
                        playAnimation()
                    }
                }
            }
        }
    }

    private fun addFavorite() {
        detailViewModel.insertDetailsMovies(detailsViewParams)
        detailViewModel.insertAllSimilarMovies(movieId, similarMovies)
    }

    private fun deleteFavorite() {
        detailViewModel.deleteDetails(movieId)
        detailViewModel.deleteSimilarMovies(movieId)
    }

    private fun loadDetailsFromDatabase() {
        detailViewModel.getDetailsWithSimilarMovies(movieId)
    }

    private fun loadGenres() {
        detailViewModel.getGenresMovies()
    }

    private fun loadMovieDetails() {
        detailViewModel.getMovieDetails(movieId)
    }

    private fun loadSimilarMovies() {
        detailViewModel.getSimilarMovies(movieId)
    }

    private fun setupClickRetry() {
        binding?.run {
            btDetailFragRetry.setOnClickListener {
                GenresCache.genresCached ?: loadGenres()
                loadMovieDetails()
                loadSimilarMovies()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }
}