package com.martayg.datasource.features.gallery.cache.impl

import com.martayg.datasource.cache.db.MyImgurDatabase
import com.martayg.datasource.features.gallery.cache.mapper.toCache
import com.martayg.datasource.features.gallery.cache.mapper.toDomain
import com.martayg.datasource.features.gallery.interfaces.GalleryDataSource
import com.martayg.datasource.features.login.interfaces.SharedPreferencesManager
import com.martayg.model.features.gallery.Image
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GalleryCacheDataSource @Inject constructor(
    private val myImgurDatabase: MyImgurDatabase,
    private val sharedPreferencesManager: SharedPreferencesManager
):GalleryDataSource{
    override fun getAllImages(page: Int, perPage: Int): Flow<List<Image>> =
        myImgurDatabase.GalleryDao().getAllImages(username=sharedPreferencesManager.usernameAuth, page=page, perPage=perPage).map { cacheImages ->
            cacheImages.map { cacheImage -> cacheImage.toDomain() } }

    override suspend fun insertImages(vararg image: Image) {
       myImgurDatabase.GalleryDao().insertImages(*image.map { domainImage ->
           domainImage.toCache()
       }.toTypedArray())
    }

}