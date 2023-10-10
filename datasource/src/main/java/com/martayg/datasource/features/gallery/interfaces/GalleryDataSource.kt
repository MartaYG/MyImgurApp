package com.martayg.datasource.features.gallery.interfaces

import com.martayg.model.features.gallery.Image
import kotlinx.coroutines.flow.Flow

interface GalleryDataSource {
    fun getAllImages(page:Int,perPage: Int): Flow<List<Image>>
}