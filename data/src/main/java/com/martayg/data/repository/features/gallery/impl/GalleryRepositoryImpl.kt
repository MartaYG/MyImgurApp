package com.martayg.data.repository.features.gallery.impl

import com.martayg.data.factory.features.gallery.GalleryFactory
import com.martayg.data.repository.features.gallery.interfaz.GalleryRepository
import com.martayg.model.features.gallery.Image
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class GalleryRepositoryImpl @Inject constructor(
    private val galleryFactory: GalleryFactory
): GalleryRepository{
    override fun getAllImages(page: Int, perPage: Int): Flow<List<Image>> = channelFlow{
         galleryFactory.RemoteGallery.getAllImages(page = page, perPage = perPage).collectLatest { remoteImages ->

             if(remoteImages.isNotEmpty()){
                 galleryFactory.CacheGallery.insertImages(*remoteImages.toTypedArray())
                 send(remoteImages)
             }else{
                 galleryFactory.CacheGallery.getAllImages(page=page, perPage=perPage).collectLatest{ cacheImages ->
                     if(cacheImages.isEmpty()){
                         send(emptyList())
                     }else{
                         send(cacheImages)
                     }
                 }
             }
         }
    }
}