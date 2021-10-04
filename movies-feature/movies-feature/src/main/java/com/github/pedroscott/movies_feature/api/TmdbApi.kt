package com.github.pedroscott.movies_feature.api

import com.github.pedroscott.movies_feature.feature.detail.data.model.Details
import com.github.pedroscott.movies_feature.feature.detail.data.model.Genres
import com.github.pedroscott.movies_feature.feature.detail.data.model.Similar
import com.github.pedroscott.movies_feature.feature.home.data.model.NowPlaying
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApi {

    @GET("movie/now_playing")
    suspend fun getNowPlayngMovies(
        @Query("page") page: Int
    ) : Response<NowPlaying>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int
    ) : Response<Details>

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path("movie_id") movieId: Int
    ) : Response<Similar>

    @GET("genre/movie/list")
    suspend fun getGenresMovies() : Response<Genres>
}