package com.github.pedroscott.movies_feature.di

import com.github.pedroscott.movies_feature.di.AppModule.viewModelModules
import com.github.pedroscott.movies_feature.di.DataModule.repositoryModules
import com.github.pedroscott.movies_feature.di.DomainModule.domainModules
import org.koin.core.module.Module

object AppComponent {

    val allModules: List<Module> get() =
        listOf(
            *allAppModules,
            *allDomainModules,
            *allDataModules
        )

    private val allAppModules: Array<Module> get() = arrayOf(viewModelModules)
    private val allDomainModules: Array<Module> get() = arrayOf(domainModules)
    private val allDataModules: Array<Module> get() = arrayOf(repositoryModules)
}