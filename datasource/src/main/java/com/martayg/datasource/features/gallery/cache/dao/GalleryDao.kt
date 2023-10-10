package com.martayg.datasource.features.gallery.cache.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.martayg.datasource.features.gallery.cache.models.CacheImage
import kotlinx.coroutines.flow.Flow

@Dao
interface GalleryDao {

    @Transaction
    @Query("SELECT * FROM images where account_url=:username LIMIT :perPage OFFSET :perPage * :page")
    fun getAllImages(username: String, page: Int, perPage: Int): Flow<List<CacheImage>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(vararg images: CacheImage)

    @Delete
    suspend fun deleteImages(vararg images: CacheImage)
}