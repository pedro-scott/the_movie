package com.github.pedroscott.movies_feature.feature.detail.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.pedroscott.movies_feature.base.BaseViewModel
import com.github.pedroscott.movies_feature.db.entity.DetailsWithSimilar
import com.github.pedroscott.movies_feature.feature.detail.data.model.*
import com.github.pedroscott.movies_feature.feature.detail.domain.DetailUseCase
import com.github.pedroscott.movies_feature.utils.Command
import kotlinx.coroutines.launch

class DetailViewModel(
    private val detailUseCase: DetailUseCase
) : BaseViewModel() {

    private val _onSuccessMovieDetails = MutableLiveData<Details>()
    val onSuccessMovieDetails: LiveData<Details> = _onSuccessMovieDetails

    private val _onSuccessSimilarMovies = MutableLiveData<List<SimilarResult>>()
    val onSuccessSimilarMovies: LiveData<List<SimilarResult>> = _onSuccessSimilarMovies

    private val _onSuccessGenresMovies = MutableLiveData<Genres>()
    val onSuccessGenresMovies: LiveData<Genres> = _onSuccessGenresMovies

    private val _onVerifyFavorite = MutableLiveData<Boolean>()
    val onVerifyFavorite: LiveData<Boolean> get() = _onVerifyFavorite

    private val _onSuccessDetailsWithSimilar = MutableLiveData<DetailsWithSimilar>()
    val onSuccessDetailsWithSimilar: LiveData<DetailsWithSimilar> get() = _onSuccessDetailsWithSimilar

    fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {
            callApi(
                call = { detailUseCase.getMovieDetails(movieId) },
                onSuccess = { data ->
                    _onSuccessMovieDetails.postValue(data as Details)
                }
            )
        }
    }

    fun getSimilarMovies(movieId: Int) {
        viewModelScope.launch {
            callApi(
                call = { detailUseCase.getSimilarMovies(movieId) },
                onSuccess = { data ->
                    (data as List<*>).let { list ->
                        _onSuccessSimilarMovies.postValue(list.filterIsInstance(SimilarResult::class.java))
                    }
                }
            )
        }
    }

    fun getGenresMovies() {
        viewModelScope.launch {
            callApi(
                call = { detailUseCase.getGenresMovies() },
                onSuccess = { data ->
                    _onSuccessGenresMovies.postValue(data as Genres)
                }
            )
        }
    }

    fun verifyFavorite(movieId: Int) {
        viewModelScope.launch {
            detailUseCase.verifyFavorite(movieId).let { isFavorite ->
                _onVerifyFavorite.postValue(isFavorite)
            }
        }
    }

    fun insertDetailsMovies(details: DetailsViewParams) {
        viewModelScope.launch {
            detailUseCase.insertDetailsMovies(details)
        }
    }

    fun insertAllSimilarMovies(detailRelatedId: Int, similarMovies: List<SimilarResultViewParams>) {
        viewModelScope.launch {
            detailUseCase.insertAllSimilarMovies(detailRelatedId, similarMovies)
        }
    }

    fun deleteDetails(movieId: Int) {
        viewModelScope.launch {
            detailUseCase.deleteDetails(movieId)
        }
    }

    fun deleteSimilarMovies(movieRelatedId: Int) {
        viewModelScope.launch {
            detailUseCase.deleteSimilarMovies(movieRelatedId)
        }
    }

    fun getDetailsWithSimilarMovies(movieId: Int) {
        viewModelScope.launch {
            command.postValue(Command.Loading(true))

            detailUseCase.getDetailsWithSimilarMovies(movieId).let { detailsWithSimilar ->
                command.postValue(Command.Loading(false))

                _onSuccessDetailsWithSimilar.postValue(detailsWithSimilar)
            }
        }
    }
}