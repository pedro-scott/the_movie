package com.github.pedroscott.movies_feature.utils

import com.github.pedroscott.movies_feature.api.ApiError
import com.github.pedroscott.movies_feature.api.ApiService
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

object ErrorUtil {

    fun parseError(response: Response<*>) : ApiError? {
        val converter: Converter<ResponseBody, ApiError> =
            ApiService.tmdbApiClient.responseBodyConverter(ApiError::class.java, arrayOfNulls<Annotation>(0))

        var error: ApiError? = null

        try {
            response.errorBody()?.let { eBody ->
                error = converter.convert(eBody)
            }
        } catch (e: IOException) {
            return ApiError
        }

        return error
    }
}