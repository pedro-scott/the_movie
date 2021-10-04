package com.github.pedroscott.movies_feature.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.pedroscott.movies_feature.utils.Command
import com.github.pedroscott.movies_feature.utils.ResponseApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseViewModel : ViewModel() {
    lateinit var command: MutableLiveData<Command>

    suspend fun <T> T.callApi(
        call: suspend () -> ResponseApi,
        onSuccess: (Any?) -> Unit,
        onError: (() -> Unit?)? = null
    ) {
        command.postValue(Command.Loading(true))

        call().let { response ->
            when(response) {
                is ResponseApi.Success -> {
                    command.postValue(Command.Loading(false))
                    onSuccess(response.data)
                }

                is ResponseApi.Error -> {
                    command.postValue(Command.Loading(false))
                    onError?.let { error ->
                        withContext(Dispatchers.Main) { error() }
                    } ?: kotlin.run {
                        command.postValue(Command.Error(response.message))
                    }
                }
            }
        }
    }
}