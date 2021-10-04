package com.github.pedroscott.movies_feature.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.pedroscott.movies_feature.db.entity.DetailEntity
import com.github.pedroscott.movies_feature.db.entity.SimilarEntity

@Database(entities = [DetailEntity::class, SimilarEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                // return instance
                return@synchronized instance
            }
        }
    }
}