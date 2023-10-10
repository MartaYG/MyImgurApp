package com.martayg.datasource.features.gallery.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class CacheImage(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "image_id")
    val imageId: String,
    @ColumnInfo(name= "account_url")
    val accountUrl: String,
    @ColumnInfo(name = "link")
    val link: String,
)
