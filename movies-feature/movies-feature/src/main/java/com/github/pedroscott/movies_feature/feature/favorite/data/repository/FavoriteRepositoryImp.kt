package com.github.pedroscott.movies_feature.feature.favorite.data.repository

import com.github.pedroscott.movies_feature.base.BaseRepository
import com.github.pedroscott.movies_feature.db.FavoriteDao
import com.github.pedroscott.movies_feature.db.entity.DetailEntity

class FavoriteRepositoryImp(
    private val favoriteDao: FavoriteDao
) : BaseRepository(), FavoriteRepository {

    override suspend fun getFavoriteList(): List<DetailEntity> =
        favoriteDao.getFavoriteList()
}