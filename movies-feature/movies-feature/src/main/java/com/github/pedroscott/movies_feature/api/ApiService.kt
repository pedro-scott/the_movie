package com.github.pedroscott.movies_feature.api

import com.airbnb.lottie.BuildConfig
import com.github.pedroscott.movies_feature.utils.Constants.TmdbApi.API_KEY_QUERY
import com.github.pedroscott.movies_feature.utils.Constants.TmdbApi.API_KEY_VALUE
import com.github.pedroscott.movies_feature.utils.Constants.TmdbApi.API_LANGUAGE_QUERY
import com.github.pedroscott.movies_feature.utils.Constants.TmdbApi.API_LANGUAGE_VALUE
import com.github.pedroscott.movies_feature.utils.Constants.TmdbApi.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiService {

    val tmdbApi: TmdbApi = tmdbApiClient.create(TmdbApi::class.java)

    val tmdbApiClient: Retrofit get() =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(interceptorClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val interceptorClient: OkHttpClient get() =
        HttpLoggingInterceptor().let { loggingInterceptor ->
            if (BuildConfig.DEBUG)
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            OkHttpClient.Builder()
                .connectTimeout(2500L, TimeUnit.MILLISECONDS)
                .readTimeout(2500L, TimeUnit.MILLISECONDS)
                .writeTimeout(2500L, TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor { chain ->
                    chain.request().url.newBuilder()
                        .addQueryParameter(API_KEY_QUERY, API_KEY_VALUE)
                        .addQueryParameter(API_LANGUAGE_QUERY, API_LANGUAGE_VALUE)
                        .build().let { url ->
                            val newRequest = chain.request().newBuilder().url(url).build()

                            chain.proceed(newRequest)
                        }
                }
                .build()
        }
}