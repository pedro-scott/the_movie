package com.github.pedroscott.movies_feature.base

import com.github.pedroscott.movies_feature.R
import com.github.pedroscott.movies_feature.utils.ErrorUtil
import com.github.pedroscott.movies_feature.utils.ResponseApi
import retrofit2.Response

open class BaseRepository {

    suspend fun <T> safeApiCall(call: suspend () -> Response<T>) : ResponseApi = safeApiResult(call)

    private suspend fun <T> safeApiResult(call: suspend () -> Response<T>) : ResponseApi =
        try {
            call().let { response ->
                if (response.isSuccessful) {
                    ResponseApi.Success(response.body())
                } else {
                    ErrorUtil.parseError(response).let { error ->
                        error?.message?.let { message ->
                            ResponseApi.Error(message)
                        } ?: ResponseApi.Error(R.string.unknow_error)
                    }
                }
            }
        } catch(e: Exception) {
            ResponseApi.Error(R.string.unknow_error)
        }
}