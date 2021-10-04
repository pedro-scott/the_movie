package com.github.pedroscott.movies_feature.feature.favorite.data.repository

import com.github.pedroscott.movies_feature.db.entity.DetailEntity

interface FavoriteRepository {

    suspend fun getFavoriteList(): List<DetailEntity>
}