package com.martayg.data.repository.features.gallery.interfaz

import com.martayg.model.features.gallery.Image
import kotlinx.coroutines.flow.Flow

interface GalleryRepository {
    fun getAllImages(page:Int,perPage: Int): Flow<List<Image>>
}