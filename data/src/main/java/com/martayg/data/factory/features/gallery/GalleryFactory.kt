package com.martayg.data.factory.features.gallery

import com.martayg.datasource.features.gallery.interfaces.GalleryDataSource
import javax.inject.Inject
import javax.inject.Named

open class GalleryFactory @Inject constructor(
    @Named("remote_gallery") val remoteGallery: GalleryDataSource,
    @Named("cache_gallery") val cacheGallery: GalleryDataSource
){}