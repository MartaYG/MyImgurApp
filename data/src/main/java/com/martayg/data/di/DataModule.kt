package com.martayg.data.di

import com.martayg.data.factory.features.gallery.GalleryFactory
import com.martayg.data.repository.features.gallery.impl.GalleryRepositoryImpl
import com.martayg.data.repository.features.gallery.interfaz.GalleryRepository
import com.martayg.data.repository.features.login.impl.LoginRepositoryImpl
import com.martayg.data.repository.features.login.interfaz.LoginRepository
import com.martayg.datasource.cache.db.MyImgurDatabase
import com.martayg.datasource.features.gallery.cache.impl.GalleryCacheDataSource
import com.martayg.datasource.features.gallery.interfaces.GalleryDataSource
import com.martayg.datasource.features.gallery.remote.api.GalleryService
import com.martayg.datasource.features.gallery.remote.impl.GalleryRemoteDataSource
import com.martayg.datasource.features.login.interfaces.LoginDataSource
import com.martayg.datasource.features.login.interfaces.SharedPreferencesManager
import com.martayg.datasource.features.login.remote.api.LoginService
import com.martayg.datasource.features.login.remote.impl.LoginRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun providesLoginRemoteDataSource(loginService: LoginService, sharedPreferencesManager: SharedPreferencesManager): LoginDataSource =
        LoginRemoteDataSource(loginService,sharedPreferencesManager)

    @Provides
    fun providesLoginRepository(loginDataSource: LoginDataSource): LoginRepository =
        LoginRepositoryImpl(loginDataSource)

    @Named("remote_gallery")
    @Provides
    fun providesGalleryRemoteDataSource(galleryService: GalleryService, sharedPreferencesManager: SharedPreferencesManager): GalleryDataSource =
        GalleryRemoteDataSource(galleryService,sharedPreferencesManager)

    @Named("cache_gallery")
    @Provides
    fun providesGalleryCacheDataSource(myImgurDatabase: MyImgurDatabase, sharedPreferencesManager: SharedPreferencesManager): GalleryDataSource =
        GalleryCacheDataSource(myImgurDatabase,sharedPreferencesManager)

    @Provides
    fun providesGalleryRepository(galleryFactory: GalleryFactory): GalleryRepository =
        GalleryRepositoryImpl(galleryFactory)
}