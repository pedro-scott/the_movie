package com.github.pedroscott.movies_feature.di

import com.github.pedroscott.movies_feature.feature.detail.domain.DetailUseCase
import com.github.pedroscott.movies_feature.feature.favorite.domain.FavoriteUseCase
import com.github.pedroscott.movies_feature.feature.home.domain.HomeUseCase
import org.koin.dsl.module

object DomainModule {

    val domainModules = module {
        single { HomeUseCase(get()) }
        single { DetailUseCase(get()) }
        single { FavoriteUseCase(get()) }
    }
}