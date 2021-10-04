package com.github.pedroscott.movies_feature.feature.favorite.domain

import com.github.pedroscott.movies_feature.extension.toListFavoriteViewParams
import com.github.pedroscott.movies_feature.feature.favorite.data.model.FavoriteViewParams
import com.github.pedroscott.movies_feature.feature.favorite.data.repository.FavoriteRepository

class FavoriteUseCase(
    private val favoriteRepository: FavoriteRepository
) {

    suspend fun getFavoriteList(): List<FavoriteViewParams> =
        favoriteRepository.getFavoriteList().toListFavoriteViewParams().sortedByDescending { it.id }
}