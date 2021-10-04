package com.github.pedroscott.movies_feature.feature.favorite.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.pedroscott.movies_feature.databinding.FragmentFavoriteBinding
import com.github.pedroscott.movies_feature.feature.favorite.adapter.FavoriteAdapter
import com.github.pedroscott.movies_feature.feature.favorite.presentation.viewmodel.FavoriteViewModel
import com.github.pedroscott.movies_feature.utils.Command
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {
    private var binding: FragmentFavoriteBinding? = null
    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private val command: MutableLiveData<Command> by lazy { MutableLiveData<Command>() }

    private val adapter: FavoriteAdapter by lazy {
        FavoriteAdapter { id ->
            findNavController().navigate(
                FavoriteFragmentDirections.actionFavoriteFragmentToDetailFragment2(id, true)
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        setupBackButton()
        setupRecyclerview()

        return binding?.root
    }

    private fun setupRecyclerview() {
        binding?.run {
            context?.let { contextNonNull ->
                rvFavoriteFragFavorites.adapter = adapter
                rvFavoriteFragFavorites.layoutManager = GridLayoutManager(contextNonNull, 2, RecyclerView.VERTICAL, false)
            }
        }
    }

    private fun setupBackButton() {
        binding?.run {
            tabFavoriteFrag.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoriteViewModel.command = command

        setupObservables()
        loadFavorites()
    }

    private fun setupObservables() {
        favoriteViewModel.onGetFavoriteList.observe(viewLifecycleOwner) { listFavorite ->
            binding?.run {
                if (listFavorite.isEmpty()) {
                    rvFavoriteFragFavorites.isVisible = false
                    lavFavoriteFragEmpty.isVisible = true
                } else {
                    rvFavoriteFragFavorites.isVisible = true
                    lavFavoriteFragEmpty.isVisible = false
                    adapter.submitList(listFavorite)
                }
            }
        }
    }

    private fun loadFavorites() {
        favoriteViewModel.getFavoriteList()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }
}