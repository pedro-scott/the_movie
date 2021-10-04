package com.github.pedroscott.movies_feature.di

import com.github.pedroscott.movies_feature.db.AppDataBase
import com.github.pedroscott.movies_feature.feature.detail.data.repository.DetailRepository
import com.github.pedroscott.movies_feature.feature.detail.data.repository.DetailRepositoryImp
import com.github.pedroscott.movies_feature.feature.favorite.data.repository.FavoriteRepository
import com.github.pedroscott.movies_feature.feature.favorite.data.repository.FavoriteRepositoryImp
import com.github.pedroscott.movies_feature.feature.home.data.repository.HomeRepository
import com.github.pedroscott.movies_feature.feature.home.data.repository.HomeRepositoryImp
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DataModule {

    val repositoryModules = module {
        single { AppDataBase.getDatabase(androidContext()).favoriteDao() }

        single<HomeRepository> { HomeRepositoryImp() }
        single<DetailRepository> { DetailRepositoryImp(get()) }
        single<FavoriteRepository> { FavoriteRepositoryImp(get()) }
    }
}