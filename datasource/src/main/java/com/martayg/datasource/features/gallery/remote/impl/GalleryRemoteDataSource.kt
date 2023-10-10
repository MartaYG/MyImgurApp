package com.martayg.datasource.features.gallery.remote.impl

import com.martayg.datasource.features.gallery.interfaces.GalleryDataSource
import com.martayg.datasource.features.gallery.remote.api.GalleryService
import com.martayg.datasource.features.gallery.remote.mappers.toDomain
import com.martayg.datasource.features.login.interfaces.SharedPreferencesManager
import com.martayg.model.features.gallery.Image
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GalleryRemoteDataSource @Inject constructor(
    private val galleryService: GalleryService,
    private val sharedPreferencesManager: SharedPreferencesManager
): GalleryDataSource{
    override fun getAllImages(page: Int, perPage: Int): Flow<List<Image>> = flow{

        val remoteAllImages = galleryService.getAllImages(username=sharedPreferencesManager.usernameAuth, page = page, perPage = perPage)

        if(remoteAllImages.isSuccessful) {
            remoteAllImages.body()?.dataImages?.let {
                emit(it.map { image -> image.toDomain() })
            }
        }else{
            emit(emptyList())
        }
    }

    override suspend fun insertImages(vararg image: Image) = throw NotImplementedError()
}