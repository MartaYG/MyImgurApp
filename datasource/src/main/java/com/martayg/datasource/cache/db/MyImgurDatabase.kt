package com.martayg.datasource.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.martayg.datasource.features.gallery.cache.dao.GalleryDao
import com.martayg.datasource.features.gallery.cache.models.CacheImage

@Database(
    entities = [
        CacheImage::class
    ],
    version = 1,
    exportSchema = true
)
abstract class MyImgurDatabase : RoomDatabase(){

    abstract fun GalleryDao():GalleryDao
}