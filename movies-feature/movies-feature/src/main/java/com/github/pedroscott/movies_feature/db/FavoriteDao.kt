package com.github.pedroscott.movies_feature.db

import androidx.room.*
import com.github.pedroscott.movies_feature.db.entity.DetailEntity
import com.github.pedroscott.movies_feature.db.entity.DetailsWithSimilar
import com.github.pedroscott.movies_feature.db.entity.SimilarEntity

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailsMovies(details: DetailEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSimilarMovies(similarMovies: List<SimilarEntity>)

    @Transaction
    @Query(value = "SELECT * FROM detail_movies WHERE detail_id = :movieId")
    suspend fun getDetailsWithSimilarMovies(movieId: Int): DetailsWithSimilar

    @Query(value = "SELECT * FROM detail_movies")
    suspend fun getFavoriteList(): List<DetailEntity>

    @Query(value = "SELECT * FROM detail_movies WHERE detail_id = :movieId")
    suspend fun verifyFavorite(movieId: Int): DetailEntity?

    @Query(value = "DELETE FROM detail_movies WHERE detail_id = :movieId")
    suspend fun deleteDetails(movieId: Int)

    @Query(value = "DELETE FROM similar_movies WHERE detail_related_id = :movieRelatedId")
    suspend fun deleteSimilarMovies(movieRelatedId: Int)
}