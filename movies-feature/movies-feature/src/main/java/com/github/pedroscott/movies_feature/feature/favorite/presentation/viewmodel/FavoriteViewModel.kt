package com.github.pedroscott.movies_feature.feature.favorite.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.pedroscott.movies_feature.base.BaseViewModel
import com.github.pedroscott.movies_feature.feature.favorite.data.model.FavoriteViewParams
import com.github.pedroscott.movies_feature.feature.favorite.domain.FavoriteUseCase
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val favoriteUseCase: FavoriteUseCase
) : BaseViewModel() {

    private val _onGetFavoriteList = MutableLiveData<List<FavoriteViewParams>>()
    val onGetFavoriteList: LiveData<List<FavoriteViewParams>> get() = _onGetFavoriteList

    fun getFavoriteList() {
        viewModelScope.launch {
            favoriteUseCase.getFavoriteList().let { listDetails ->
                _onGetFavoriteList.postValue(listDetails)
            }
        }
    }
}