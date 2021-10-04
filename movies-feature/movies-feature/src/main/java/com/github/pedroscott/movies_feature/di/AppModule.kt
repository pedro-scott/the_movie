package com.github.pedroscott.movies_feature.di

import com.github.pedroscott.movies_feature.feature.detail.presentation.viewmodel.DetailViewModel
import com.github.pedroscott.movies_feature.feature.favorite.presentation.viewmodel.FavoriteViewModel
import com.github.pedroscott.movies_feature.feature.home.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {

    val viewModelModules = module {
        viewModel { HomeViewModel(get()) }
        viewModel { DetailViewModel(get()) }
        viewModel { FavoriteViewModel(get()) }
    }
}