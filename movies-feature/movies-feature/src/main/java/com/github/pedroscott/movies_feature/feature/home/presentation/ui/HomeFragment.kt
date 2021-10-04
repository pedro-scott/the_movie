package com.github.pedroscott.movies_feature.feature.home.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.pedroscott.movies_feature.R
import com.github.pedroscott.movies_feature.databinding.FragmentHomeBinding
import com.github.pedroscott.movies_feature.feature.home.adapter.NowPlayingAdapter
import com.github.pedroscott.movies_feature.feature.home.presentation.viewmodel.HomeViewModel
import com.github.pedroscott.movies_feature.utils.Command
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null
    private val homeViewModel: HomeViewModel by viewModel()
    private val command: MutableLiveData<Command> by lazy {
        MutableLiveData<Command>()
    }

    private val adapter: NowPlayingAdapter by lazy {
        NowPlayingAdapter { id ->
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(id)
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()
        setupMenuItemClick()

        return binding?.root
    }

    private fun setupRecyclerView() {
        binding?.run {
            context?.let { contextNonNull ->
                rvHomeFragNowPlaying.adapter = adapter
                rvHomeFragNowPlaying.layoutManager =
                    GridLayoutManager(
                        contextNonNull,
                        2,
                        RecyclerView.VERTICAL,
                        false
                    )
            }
        }
    }

    private fun setupMenuItemClick() {
        binding?.run {
            tabHomeFrag.setOnMenuItemClickListener { item ->
                if (item.itemId == R.id.favorite) {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToFavoriteFragment()
                    )

                    true
                } else false
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.command = command

        setupStates()
        setupClickRetry()
        loadMovies()
    }

    private fun loadMovies(isRetry: Boolean = false) {
        lifecycleScope.launch {
            homeViewModel.getNowPlayingMovies().collectLatest { pagingData ->
                if (!homeViewModel.isCreated || isRetry)
                    adapter.submitData(pagingData)
            }
        }

        homeViewModel.notifyThatIsCreated()
    }

    private fun setupStates() {
        lifecycleScope.launch {
            adapter.loadStateFlow.collect { loadState ->
                binding?.run {
                    (loadState.refresh is LoadState.NotLoading && adapter.itemCount == 0).let { error ->
                        gpHomeFragError.isVisible = error
                    }

                    (loadState.source.refresh is LoadState.Loading).let { loading ->
                        gpHomeFragLoading.isVisible = loading
                    }
                }
            }
        }
    }

    private fun setupClickRetry() {
        binding?.run {
            btHomeFragRetry.setOnClickListener {
                loadMovies(true)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }
}